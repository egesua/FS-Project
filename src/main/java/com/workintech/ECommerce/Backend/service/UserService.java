package com.workintech.ECommerce.Backend.service;

import com.workintech.ECommerce.Backend.api.model.RegistrationBody;
import com.workintech.ECommerce.Backend.dao.LocalUserDAO;
import com.workintech.ECommerce.Backend.entity.LocalUser;
import com.workintech.ECommerce.Backend.exception.UserAlreadyExistsException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private LocalUserDAO localUserDAO;

    public UserService(LocalUserDAO localUserDAO){
        this.localUserDAO = localUserDAO;
    }

    public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {

        if (localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent() || localUserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException();
        }

        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setUsername(registrationBody.getUsername());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());

        //TODO: ENCRYPT passwords!
        user.setPassword(registrationBody.getPassword());
        return localUserDAO.save(user);
    }

}
