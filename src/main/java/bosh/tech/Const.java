package bosh.tech;

public final class Const
{
    public static String BASE_PATH = Const.class.getClassLoader().getResource("./").getPath().substring(1);
    public static final String ORDERER_DOMAIN_NAME = "orderer.example.com";
    public static final String PEER_ASSOCIATION_DOMAIN_NAME = "peer0.CrabAssociation.com";
    public static final String PEER_PRODUCER_DOMAIN_NAME = "peer0.CrabProducer.com";
    public static final String PEER_CARRIER_DOMAIN_NAME = "pee0.CrabCarrier.com";
    public static final String PEER_SELLER_DOMAIN_NAME = "peer0.CrabSeller.com";

    public static final String HOST_PREFIX = "grpcs://";
    public static final String ORDERER_HOST = ":7050";
    public static final String PEER_ASSOCIATION_HOST = ":7051";
    public static final String PEER_PRODUCER_HOST = ":8051";
    public static final String PEER_CARRIER_HOST = ":9051";
    public static final String PEER_SELLER_HOST = ":10051";

    public static final String ORDERER_TLS_DIR = "crypto-config/ordererOrganizations/example.com/orderers/orderer.example.com/tls/server.crt";
    public static final String PEER_ASSOCIATION_TLS_DIR = "crypto-config/peerOrganizations/CrabAssociation.com/peers/peer0.CrabAssociation.com/tls/server.crt";
    public static final String PEER_PRODUCER_TLS_DIR = "crypto-config/peerOrganizations/CrabProducer.com/peers/peer0.CrabProducer.com/tls/server.crt";
    public static final String PEER_CARRIER_TLS_DIR = "crypto-config/peerOrganizations/CrabCarrier.com/peers/peer0.CrabCarrier.com/tls/server.crt";
    public static final String PEER_SELLER_TLS_DIR = "crypto-config/peerOrganizations/CrabSeller.com/peers/peer0.CrabSeller.com/tls/server.crt";

    public static final String CHANNEL_NAME = "crabchannel";
    public static final String CHAINCODE_NAME = "crabcc";

    public static final String ASSOCIATION_MSP_ID = "CrabAssociationMSP";
    public static final String ASSOCIATION_AFFILIATION = "CrabAssociation";
    public static final String ASSOCIATION_KEY_FILE = "crypto-config/peerOrganizations/CrabAssociation.com/users/Admin@CrabAssociation.com/msp/keystore/b16d35f62b31baf6d177f6dc2c25cb9e98d9f5917b0116eebfbd25a9e9fa552b_sk";
    public static final String ASSOCIATION_CERT_FILE = "crypto-config/peerOrganizations/CrabAssociation.com/users/Admin@CrabAssociation.com/msp/signcerts/Admin@CrabAssociation.com-cert.pem";

    public static final String PRODUCER_MSP_ID = "CrabProducerMSP";
    public static final String PRODUCER_AFFILIATION = "CrabProducer";
    public static final String PRODUCER_KEY_FILE = "crypto-config/peerOrganizations/CrabProducer.com/users/Admin@CrabProducer.com/msp/keystore/ec79eb94dd114fb47709e7092320487158cf9cab7787d982bf109d36b059c746_sk";
    public static final String PRODUCER_CERT_FILE = "crypto-config/peerOrganizations/CrabProducer.com/users/Admin@CrabProducer.com/msp/signcerts/Admin@CrabProducer.com-cert.pem";

    public static final String CARRIER_MSP_ID = "CrabCarrierMSP";
    public static final String CARRIER_AFFILIATION = "CrabCarrier";
    public static final String CARRIER_KEY_FILE = "crypto-config/peerOrganizations/CrabCarrier.com/users/Admin@CrabCarrier.com/msp/keystore/ca9394984b23d90953e3bf5f252b6a2d72b12f1d3130e59ee707f8654ce024ef_sk";
    public static final String CARRIER_CERT_FILE = "crypto-config/peerOrganizations/CrabCarrier.com/users/Admin@CrabCarrier.com/msp/signcerts/Admin@CrabCarrier.com-cert.pem";

    public static final String SELLER_MSP_ID = "CrabSellerMSP";
    public static final String SELLER_AFFILIATION = "CrabSeller";
    public static final String SELLER_KEY_FILE = "crypto-config/peerOrganizations/CrabSeller.com/users/Admin@CrabSeller.com/msp/keystore/803b78569e9c6c8d980461c53b8d89f7825f6b31a7d7297d713689d033a7b853_sk";
    public static final String SELLER_CERT_FILE = "crypto-config/peerOrganizations/CrabSeller.com/users/Admin@CrabSeller.com/msp/signcerts/Admin@CrabSeller.com-cert.pem";


    public static final String ORDERER_CLIENT_CERT = "crypto-config/ordererOrganizations/example.com/users/Admin@example.com/tls/client.crt";
    public static final String ORDERER_CLIENT_KEY  = "crypto-config/ordererOrganizations/example.com/users/Admin@example.com/tls/client.key";
    public static final String ASSOCIATION_CLIENT_CERT = "crypto-config/peerOrganizations/CrabAssociation.com/users/Admin@CrabAssociation.com/tls/client.crt";
    public static final String ASSOCIATION_CLIENT_KEY  = "crypto-config/peerOrganizations/CrabAssociation.com/users/Admin@CrabAssociation.com/tls/client.key";
    public static final String PRODUCER_CLIENT_CERT = "crypto-config/peerOrganizations/CrabProducer.com/users/Admin@CrabProducer.com/tls/client.crt";
    public static final String PRODUCER_CLIENT_KEY  = "crypto-config/peerOrganizations/CrabProducer.com/users/Admin@CrabProducer.com/tls/client.key";
    public static final String CARRIER_CLIENT_CERT = "crypto-config/peerOrganizations/CrabCarrier.com/users/Admin@CrabCarrier.com/tls/client.crt";
    public static final String CARRIER_CLIENT_KEY  = "crypto-config/peerOrganizations/CrabCarrier.com/users/Admin@CrabCarrier.com/tls/client.key";
    public static final String SELLER_CLIENT_CERT = "crypto-config/peerOrganizations/CrabSeller.com/users/Admin@CrabSeller.com/tls/client.crt";
    public static final String SELLER_CLIENT_KEY  = "crypto-config/peerOrganizations/CrabSeller.com/users/Admin@CrabSeller.com/tls/client.key";

    public static final String USER_PREFIX = "user/";
    public static final String USER_KEY_FILE = "/key";
    public static final String USER_CERT_FILE= "/cert.pem";
}
