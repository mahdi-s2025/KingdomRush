package com.kingdom_rush.controller;

import com.kingdom_rush.model.*;
import lombok.Getter;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Setter
public class PlayerController {
    @Getter
    private static final PlayerController instance = new PlayerController();

    private PlayerController() {}

    @Getter
    private Player player;

    public void signup(String username, String password) throws Exception {
        checkUsername(username);
        checkPassword(password);
        Spell[] backpack = new Spell[4];
        backpack[0] = new HealthSpell(1);
        backpack[1] = new FreezeSpell(1);
        backpack[2] = new CoinSpell(1);
        backpack[3] = new LittleBoySpell(1);
        player = new Player(username, password, 1, 100, backpack);
        DBController.getInstance().insertPlayer(player);
    }

    private void checkUsername(String username) throws Exception {
        if (DBController.getInstance().findPlayer(username) != null)
            throw new Exception("Username already exists!");
        Pattern usernamePattern = Pattern.compile("^[A-Za-z1-9]+(_)?[A-Za-z1-9]+$");
        Matcher usernameMatcher = usernamePattern.matcher(username);
        if (!usernameMatcher.matches()) {
            throw new Exception("Username is invalid!");
        }
    }

    private void checkPassword(String password) throws Exception {
        switch (passwordStrength(password)) {
            case 0 -> throw new Exception("The password is too short.\nIt must have more than 8 characters");
            case 1 -> throw new Exception("The password is weak. Its strength is 1 out of 4." +
                    "\nYou must use 0-9, a-z, A-Z, and at least one\nspecial character: ! @ # % ^ & * ( )");
            case 2 -> throw new Exception("The password is weak. Its strength is 2 out of 4." +
                    "\nYou must use 0-9, a-z, A-Z, and at least one\nspecial character: ! @ # % ^ & * ( )");
            case 3 -> throw new Exception("The password is weak. Its strength is 3 out of 4." +
                    "\nYou must use 0-9, a-z, A-Z, and at least one\nspecial character: ! @ # % ^ & * ( )");
            case 5 -> throw new Exception("The password is too long.\nIt shouldn't have more than 30 characters");
            case 6 -> throw new Exception("The password has invalid character." +
                    "\nYou must use 0-9, a-z, A-Z, and at least one special character: ! @ # % ^ & * ( )");
            default -> {}
        }
    }

    private int passwordStrength(String password) {
        int strength = 0;
        if (password.length() < 8)
            return 0;

        if (password.length() > 30)
            return 5;

        Pattern smallLetterPattern = Pattern.compile("^(?=([\\w\\d!@#$%^&*()]*[a-z]))[\\w\\d!@#$%^&*()]*$");
        Matcher smallLetterMatcher = smallLetterPattern.matcher(password);
        if (smallLetterMatcher.matches()) strength++;

        Pattern numberPattern = Pattern.compile("^(?=([\\w\\d!@#$%^&*()]*[0-9]))[\\w\\d!@#$%^&*()]*$");
        Matcher numberMatcher = numberPattern.matcher(password);
        if (numberMatcher.matches()) strength++;

        Pattern capitalLetterPattern = Pattern.compile("^(?=([\\w\\d!@#$%^&*()]*[A-Z]))[\\w\\d!@#$%^&*()]*$");
        Matcher capitalLetterMatcher = capitalLetterPattern.matcher(password);
        if (capitalLetterMatcher.matches()) strength++;

        Pattern characterPattern = Pattern.compile("^(?=([\\w\\d!@#$%^&*()]*[!@#$%^&*()]))[\\w\\d!@#$%^&*()]*$");
        Matcher characterMatcher = characterPattern.matcher(password);
        if (characterMatcher.matches()) strength++;

        if (strength == 0) return 6;
        return strength;
    }

    public void login(String username, String password) throws Exception {
        Player tmp = DBController.getInstance().findPlayer(username);
        if (tmp == null || !tmp.getPassword().equals(password))
            throw new Exception("Username or password is invalid!");
        player = tmp;
    }
}
