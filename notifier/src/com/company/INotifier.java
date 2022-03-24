package com.company;

import com.company.entity.Entity;
import com.company.entity.EntityType;

public interface INotifier {
    void doNotify(Entity entityObj, Entity originalEntityObj, EntityType entityType);
}
