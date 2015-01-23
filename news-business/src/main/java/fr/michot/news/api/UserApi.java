package fr.michot.news.api;

import fr.michot.news.entities.UserDb;
import fr.michot.news.repositories.UserRepository;
import fr.michot.news.ui.UserUI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright MIMIGREG
 * Created by mimigreg on 20/01/2015.
 */
@Controller
@RequestMapping("/user")
public class UserApi extends AbstractApi {

    @Inject
    UserRepository userRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = {"{userId}"}, method = {RequestMethod.PUT}, consumes = "application/json")
    @Transactional
    @ResponseBody
    public UserUI smashUser(@PathVariable("userId") String userId, @RequestBody @Valid UserUI userUI) {
        UserDb userDb = userRepository.findOne(userId);
        if (userDb == null) {
            throw new InvalidParameterException("User "+userId+" Not found");
        }
        userDb = userUI.smashWithUserDb(userDb);
        return UserUI.fromUserDb(userDb);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = {RequestMethod.PUT}, consumes = "application/json")
    @Transactional
    @ResponseBody
    public UserUI createUser(@RequestBody @Valid UserUI userUI) {
        UserDb userDb = userRepository.save(userUI.toUserDb());
        return UserUI.fromUserDb(userDb);
    }

    @PreAuthorize("#userUI.email == authentication.name")
    @RequestMapping(value = {"{userId}"}, method = {RequestMethod.POST}, consumes = "application/json")
    @Transactional
    @ResponseBody
    public UserUI completeUser(@PathVariable("userId") String userId, @RequestBody @Valid UserUI userUI) {
        // PreAutorize should makes that userUI and userUI.email never null in there
        UserDb userDb = userRepository.findOne(userId);

        if (userDb == null) {
            throw new InvalidParameterException("User "+userId+" Not found");
        } else {
            userDb = userUI.toUserDb(userDb);
        }
        return UserUI.fromUserDb(userDb);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = {"{userId}"}, method = RequestMethod.DELETE)
    @Transactional
    public void deleteUser(@PathVariable("userId") String userId) {
        userRepository.delete(userId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = {"{userId}"}, method = RequestMethod.GET)
    @Transactional
    public UserUI getUser(@PathVariable("userId") String userId) {
        return UserUI.fromUserDb(userRepository.findOne(userId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    @Transactional
    @ResponseBody
    public Page<UserUI> findUsers(@RequestParam(required = false) Pageable pageable, @RequestParam(required = false) String name, @RequestParam(required = false) String firstname, @RequestParam(required = false) Long groupId) {
        List<UserUI> userUIs = new ArrayList<>();

        Page<UserDb> userDbs;
        if (name == null && firstname == null && groupId == null) {
            userDbs = userRepository.findAll(pageable);
        } else {
            String nameParam = name == null ? "" : name ;
            String firstNameParam = firstname == null ? "" : firstname ;
            userDbs = userRepository.findByNameContainsAndFirstNameContainsOrderByNameAsc(pageable, nameParam, firstNameParam);
        }

        for (UserDb user : userDbs.getContent()) {
            userUIs.add(UserUI.fromUserDb(user));
        }

        return new PageImpl<>(userUIs, pageable, userDbs.getTotalElements());
    }



}
