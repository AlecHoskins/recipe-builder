//package com.alechoskins.RecipeSharingApi.config;
//
//import jakarta.persistence.EntityManager;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
//import org.springframework.data.repository.core.support.QueryCreationListener;
//import org.springframework.data.repository.core.support.RepositoryFactorySupport;
//import org.springframework.data.repository.query.RepositoryQuery;
//
//import java.util.Map;
//
//@Configuration
//@EnableJpaRepositories(basePackages = "com.alechoskins.RecipeSharingApi.database.repository")
//public class JpaConfiguration {
//
//    private static final Logger logger = LoggerFactory.getLogger(JpaConfiguration.class);
//
//    @Bean
//    public RepositoryFactorySupport repositoryFactory(EntityManager entityManager) {
//        JpaRepositoryFactory factory = new JpaRepositoryFactory(entityManager);
//
//        // Register a custom query execution listener
//        factory.addQueryCreationListener(new QueryCreationListener<RepositoryQuery>() {
//            @Override
//            public void onCreation(RepositoryQuery query) {
//                logger.info("Created query using: " + query.getQueryMethod().getName());
//            }
//
//            @Override
//            public <T> void beforeQuery(QueryInformation<T> queryInformation) {
//                logger.info("Executing SQL query: " + queryInformation.getQueryString());
//
//                Map<String, Object> namedParameters = queryInformation.getBinder().getBindings().getBoundParameters();
//                if (!namedParameters.isEmpty()) {
//                    logger.info("Query Parameters:");
//                    for (Map.Entry<String, Object> entry : namedParameters.entrySet()) {
//                        logger.info(entry.getKey() + " = " + entry.getValue());
//                    }
//                }
//            }
//        });
//
//        return factory;
//    }
//}
