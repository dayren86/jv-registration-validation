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
        if (user.getLogin().length() <= 6) {
            throw new RegistrationException("Login less than 6 characters");
        }
        if (user.getPassword().length() <= 6) {
            throw new RegistrationException("Password less than 6 characters");
        }
        if (user.getAge() < 18) {
            throw new RegistrationException("Age under 18");
        }

        return storageDao.add(user);
    }
}
