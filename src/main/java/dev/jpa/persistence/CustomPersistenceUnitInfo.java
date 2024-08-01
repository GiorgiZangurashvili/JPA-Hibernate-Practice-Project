package dev.jpa.persistence;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;

import javax.sql.DataSource;
import java.net.URL;
import java.util.*;

public class CustomPersistenceUnitInfo implements PersistenceUnitInfo {
    @Override
    public String getPersistenceUnitName() {
        return "pu";
    }

    @Override
    public String getPersistenceProviderClassName() {
        return "org.hibernate.jpa.HibernatePersistenceProvider";
    }

    @Override
    public PersistenceUnitTransactionType getTransactionType() {
        return PersistenceUnitTransactionType.RESOURCE_LOCAL;
    }

    @Override
    public DataSource getJtaDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/jpa");
        hikariDataSource.setUsername("postgres");
        hikariDataSource.setPassword("spring");
        return hikariDataSource;
    }

    @Override
    public DataSource getNonJtaDataSource() {
        return null;
    }

    @Override
    public List<String> getMappingFileNames() {
        return List.of();
    }

    @Override
    public List<URL> getJarFileUrls() {
        return List.of();
    }

    @Override
    public URL getPersistenceUnitRootUrl() {
        return null;
    }

    @Override
    public List<String> getManagedClassNames() {
        return List.of("dev.jpa.entity.pk.generatedvalue.Product",
                "dev.jpa.entity.pk.generatedvalue.Employee",
                "dev.jpa.entity.pk.composed.EntityWithComposedPK",
                "dev.jpa.entity.pk.composed.EntityWithComposedPK2",
                "dev.jpa.entity.oneto.one.Person",
                "dev.jpa.entity.oneto.one.Passport",
                "dev.jpa.entity.secondarytable.User",
                "dev.jpa.entity.oneto.many.Comment",
                "dev.jpa.entity.oneto.many.Post",
                "dev.jpa.entity.manyto.many.Company",
                "dev.jpa.entity.manyto.many.Developer",
                "dev.jpa.entity.oneto.one.test.Woman",
                "dev.jpa.entity.oneto.one.test.Man",
                "dev.jpa.entity.oneto.many.test.Tate",
                "dev.jpa.entity.oneto.many.test.Bugatti",
                "dev.jpa.entity.manyto.many.test.Human",
                "dev.jpa.entity.manyto.many.test.Hobby",
                "dev.jpa.entity.inheritance.ProductInSale",
                "dev.jpa.entity.inheritance.Book",
                "dev.jpa.entity.inheritance.ElectronicDevice",
                "dev.jpa.entity.jpql.simple.FootballPlayer",
                "dev.jpa.entity.jpql.join.Enrollment",
                "dev.jpa.entity.jpql.join.Student",
                "dev.jpa.entity.jpql.join.Course",
                "dev.jpa.entity.criteria.Customer");
    }

    @Override
    public boolean excludeUnlistedClasses() {
        return false;
    }

    @Override
    public SharedCacheMode getSharedCacheMode() {
        return null;
    }

    @Override
    public ValidationMode getValidationMode() {
        return null;
    }

    @Override
    public Properties getProperties() {
        Properties props = new Properties();
        props.put("hibernate.show_sql", "true");
//        props.put("hibernate.hbm2ddl.auto", "create");
        props.put("hibernate.physical_naming_strategy", "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy");
        return props;
    }

    @Override
    public String getPersistenceXMLSchemaVersion() {
        return "";
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override
    public void addTransformer(ClassTransformer classTransformer) {

    }

    @Override
    public ClassLoader getNewTempClassLoader() {
        return null;
    }
}
