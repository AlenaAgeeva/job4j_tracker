package ru.job4j.tracker.main.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import ru.job4j.tracker.main.store.Store;
import ru.job4j.tracker.main.model.Item;

import java.util.Collections;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(item);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Item updatedItem = new Item();
            updatedItem.setId(id);
            updatedItem.setName(item.getName());
            session.update(updatedItem);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Item item = new Item();
            item.setId(id);
            session.remove(item);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean deleteAll() {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            findAll().forEach(session::remove);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        try {
            return session.createQuery("FROM Item", Item.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return Collections.emptyList();
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        try {
            Query<Item> query = session.createQuery("FROM Item WHERE name = :key", Item.class);
            query.setParameter("key", key);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return Collections.emptyList();
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        try {
            return session.get(Item.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
