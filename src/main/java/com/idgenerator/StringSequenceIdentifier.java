//package com.idgenerator;
//
//import java.io.Serializable;
//import java.util.Properties;
//
//import javax.imageio.spi.ServiceRegistry;
//
//import org.hibernate.HibernateException;
//import org.hibernate.MappingException;
//import org.hibernate.dialect.Dialect;
//import org.hibernate.engine.config.spi.ConfigurationService;
//import org.hibernate.engine.spi.SessionImplementor;
//import org.hibernate.exception.spi.Configurable;
//import org.hibernate.id.IdentifierGenerator;
//import org.hibernate.id.enhanced.SequenceStyleGenerator;
//import org.hibernate.internal.util.config.ConfigurationHelper;
//
//import com.google.protobuf.Type;
//import com.mysql.cj.Session;
//
//public class StringSequenceIdentifier<JdbcEnvironment> implements
//        IdentifierGenerator, Configurable {
// 
//    public static final String SEQUENCE_PREFIX = "sequence_prefix";
// 
//    private String sequencePrefix;
// 
//    private String sequenceCallSyntax;
// 
//    public void configure(
//            Type type,
//            Properties params,
//            ServiceRegistry serviceRegistry)
//        throws MappingException {
// 
//        final JdbcEnvironment jdbcEnvironment = ((Object) serviceRegistry)
//        .getService(
//            JdbcEnvironment.class
//        );
// 
//        final Dialect dialect = jdbcEnvironment.getDialect();
// 
//        final ConfigurationService configurationService = serviceRegistry
//        .getService(
//            ConfigurationService.class
//        );
// 
//        String globalEntityIdentifierPrefix = configurationService
//        .getSetting(
//            "entity.identifier.prefix",
//            String.class,
//            "SEQ_"
//        );
// 
//        sequencePrefix = ConfigurationHelper
//        .getString(
//            SEQUENCE_PREFIX,
//            params,
//            globalEntityIdentifierPrefix
//        );
// 
//        final String sequencePerEntitySuffix = ConfigurationHelper
//        .getString(
//            SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX,
//            params,
//            SequenceStyleGenerator.DEF_SEQUENCE_SUFFIX
//        );
// 
//        boolean preferSequencePerEntity = ConfigurationHelper
//        .getBoolean(
//            SequenceStyleGenerator.CONFIG_PREFER_SEQUENCE_PER_ENTITY,
//            params,
//            false
//        );
// 
//        final String defaultSequenceName = preferSequencePerEntity
//            ? params.getProperty(JPA_ENTITY_NAME) + sequencePerEntitySuffix
//            : SequenceStyleGenerator.DEF_SEQUENCE_NAME;
// 
//        sequenceCallSyntax = dialect
//        .getSequenceNextValString(
//            ConfigurationHelper.getString(
//                SequenceStyleGenerator.SEQUENCE_PARAM,
//                params,
//                defaultSequenceName
//            )
//        );
//    }
// 
//    @Override
//    public Serializable generate(
//            SharedSessionContractImplementor session,
//            Object obj) {
//             
//        if (obj instanceof Identifiable) {
//            Identifiable identifiable = (Identifiable) obj;
//            Serializable id = identifiable.getId();
// 
//            if (id != null) {
//                return id;
//            }
//        }
// 
//        long seqValue = ((Number)
//            Session.class.cast(session)
//            .createNativeQuery(sequenceCallSyntax)
//            .uniqueResult()
//        ).longValue();
// 
//        return sequencePrefix + String.format("%011d%s", 0 ,seqValue);
//    }
//
//	@Override
//	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void configure(Properties properties) throws HibernateException {
//		// TODO Auto-generated method stub
//		
//	}
//}