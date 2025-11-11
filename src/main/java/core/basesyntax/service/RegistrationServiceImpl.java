package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.User;

public class RegistrationServiceImpl implements RegistrationService {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public User register(User user) {
        if (storageDao.get(user.getLogin()) != null) {
            throw new RegistrationException("User already exists");
        }
        if (user.getLogin() == null || user.getLogin().length() < 6 || user.getLogin().length() > 25) {
            throw new RegistrationException("Login less than 6 characters");
        }
        if (user.getPassword() == null || user.getPassword().length() < 6 || user.getPassword().length() > 25) {
            throw new RegistrationException("Password less than 6 characters");
        }
        if (user.getAge() == null || user.getAge() < 18 || user.getAge() > 80) {
            throw new RegistrationException("Age is not correct. Age must be no less than 18 and no more than 80");
        }

        return storageDao.add(user);
    }
}
