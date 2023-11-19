package net.ausiasmarch.tiendaonlineserver.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.transaction.annotation.Transactional;
import net.ausiasmarch.tiendaonlineserver.entity.UserEntity;
import net.ausiasmarch.tiendaonlineserver.exception.ResourceNotFoundException;
import net.ausiasmarch.tiendaonlineserver.repository.UserRepository;

@Service
public class UserService {

    private final String tiendaOnlinePassword = "e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e";

    @Autowired
    UserRepository oUserRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SessionService oSessionService;

    public UserEntity get(Long id) {
        return oUserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public UserEntity getByUsername(String username) {
        return oUserRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found by username"));
    }

    public Long create(UserEntity oUserEntity) {
        oSessionService.onlyAdmins();
        oUserEntity.setId(null);
        oUserEntity.setPassword(tiendaOnlinePassword);
        return oUserRepository.save(oUserEntity).getId();
    }

    public UserEntity update(UserEntity oUserEntityToSet) {
        UserEntity oUserEntityFromDatabase = this.get(oUserEntityToSet.getId());
        
        if (oUserEntityFromDatabase != null) {
            oSessionService.onlyAdminsOrUsersWithIisOwnData(oUserEntityFromDatabase.getId());
    
            if (oSessionService.isUser()) {
               
                oUserEntityToSet.setId(oUserEntityFromDatabase.getId());
                oUserEntityToSet.setRole(oUserEntityFromDatabase.getRole());
                oUserEntityToSet.setPassword(tiendaOnlinePassword);
                return oUserRepository.save(oUserEntityToSet);
            } else {
               
                oUserEntityToSet.setId(oUserEntityFromDatabase.getId());
                oUserEntityToSet.setPassword(tiendaOnlinePassword);
                return oUserRepository.save(oUserEntityToSet);
            }
        } else {
            return null; 
        }
    }
    public Long delete(Long id) {
        oSessionService.onlyAdmins();
        oUserRepository.deleteById(id);
        return id;
    }

    public Page<UserEntity> getPage(Pageable oPageable) {
        oSessionService.onlyAdmins();
        return oUserRepository.findAll(oPageable);
    }

    public Long populate(Integer amount) {
        oSessionService.onlyAdmins();
        for (int i = 0; i < amount; i++) {
            oUserRepository.save(new UserEntity("name" + i, "surname" + i, "lastname" + i,
                    "email" + i + "@ausiasmarch.net", "address" + i, "username" + i,
                    "e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e", true));
        }
        return oUserRepository.count();
    }

    @Transactional
    public Long empty() {
        oSessionService.onlyAdmins();
        oUserRepository.deleteAll();
        oUserRepository.resetAutoIncrement();
        UserEntity oUserEntity1 = new UserEntity(1L, "Kira", "Chan", "",
                "kira@gmail.com", "santa Ana 16 4A ", "kirachan", tiendaOnlinePassword, false);
        oUserRepository.save(oUserEntity1);
        oUserEntity1 = new UserEntity(2L, "Silvia", "Alcañiz", "Puig", "moni5@gmail.com", "santa Catalina 16 4A",
                "monichan", tiendaOnlinePassword, true);
        oUserRepository.save(oUserEntity1);
        return oUserRepository.count();
    }

}
