package bosh.tech;
import org.hyperledger.fabric.sdk.*;
import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.ProposalException;
import org.hyperledger.fabric.sdk.exception.TransactionException;
import org.hyperledger.fabric.sdk.security.CryptoSuite;

import com.alibaba.fastjson.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class FabricService
{

    public static String USER_MSP_ID = "";
    public static String USER_AFFILIATION = "";
    public static String USER_KEY_FILE = "";
    public static String USER_CERT_FILE = "";
    public static String PEER_DOMAIN_NAME = "";
    public static String PEER_HOST = "";
    public static String PEER_TLS_DIR = "";
    public static String PEER_CLIENT_KEY = "";
    public static String PEER_CLIENT_CERT = "";
    public static String ORDERER_HOST = "";

    public static CryptoSuite cryptoSuite = null;
    public static HFClient client = null;
    public static Channel channel = null;
    public static Peer peer = null;
    public static Orderer orderer = null;
    public ChaincodeID chaincodeID = null;
    public static FabUser fabUser = null ;

    public void Init(String userName,int Org,String serverHost) throws ClassNotFoundException, InstantiationException, IllegalAccessException, CryptoException, IOException, InvalidArgumentException, TransactionException, NoSuchMethodException, InvocationTargetException, ProposalException {
        if(Org == 0 || Org == 1)
        {
            PEER_DOMAIN_NAME = Const.PEER_ASSOCIATION_DOMAIN_NAME;
            PEER_HOST = Const.HOST_PREFIX + serverHost + Const.PEER_ASSOCIATION_HOST;
            PEER_TLS_DIR = Const.PEER_ASSOCIATION_TLS_DIR;
            PEER_CLIENT_CERT = Const.ASSOCIATION_CLIENT_CERT;
            PEER_CLIENT_KEY = Const.ASSOCIATION_CLIENT_KEY;

            USER_MSP_ID = Const.ASSOCIATION_MSP_ID;
            USER_AFFILIATION = Const.ASSOCIATION_AFFILIATION;
            USER_KEY_FILE = Const.ASSOCIATION_KEY_FILE;
            USER_CERT_FILE = Const.ASSOCIATION_CERT_FILE;
        }else if(Org == 2)
        {
            PEER_DOMAIN_NAME = Const.PEER_PRODUCER_DOMAIN_NAME;
            PEER_HOST = Const.HOST_PREFIX + serverHost + Const.PEER_PRODUCER_HOST;
            PEER_TLS_DIR = Const.PEER_PRODUCER_TLS_DIR;
            PEER_CLIENT_CERT = Const.PRODUCER_CLIENT_CERT;
            PEER_CLIENT_KEY = Const.PRODUCER_CLIENT_KEY;

            USER_MSP_ID = Const.PRODUCER_MSP_ID;
            USER_AFFILIATION = Const.PRODUCER_AFFILIATION;
        }else if(Org == 3 )
        {
            PEER_DOMAIN_NAME = Const.PEER_CARRIER_DOMAIN_NAME;
            PEER_HOST = Const.HOST_PREFIX + serverHost + Const.PEER_CARRIER_HOST;
            PEER_TLS_DIR = Const.PEER_CARRIER_TLS_DIR;
            PEER_CLIENT_CERT = Const.CARRIER_CLIENT_CERT;
            PEER_CLIENT_KEY = Const.CARRIER_CLIENT_KEY;

            USER_MSP_ID = Const.CARRIER_MSP_ID;
            USER_AFFILIATION = Const.CARRIER_AFFILIATION;
        }else if(Org == 4)
        {
            PEER_DOMAIN_NAME = Const.PEER_SELLER_DOMAIN_NAME;
            PEER_HOST = Const.HOST_PREFIX + serverHost + Const.PEER_SELLER_HOST;
            PEER_TLS_DIR = Const.PEER_SELLER_TLS_DIR;
            PEER_CLIENT_CERT = Const.SELLER_CLIENT_CERT;
            PEER_CLIENT_KEY = Const.SELLER_CLIENT_KEY;

            USER_MSP_ID = Const.SELLER_MSP_ID;
            USER_AFFILIATION = Const.SELLER_AFFILIATION;
        }else
        {
            System.out.println("Init Org Wrong");
            return ;
        }
        ORDERER_HOST = Const.HOST_PREFIX + serverHost + Const.ORDERER_HOST;
        if(Org != 0)
        {
            USER_KEY_FILE = Const.USER_PREFIX + userName + Const.USER_KEY_FILE;
            USER_CERT_FILE = Const.USER_PREFIX + userName + Const.USER_CERT_FILE;
        }

        //set cryptosuite
        cryptoSuite = CryptoSuite.Factory.getCryptoSuite();

        //set client
        client = HFClient.createNewInstance();
        client.setCryptoSuite(cryptoSuite);

        //set user
        fabUser = new FabUser(userName,USER_MSP_ID,USER_KEY_FILE,USER_CERT_FILE);
        client.setUserContext(fabUser);

        //create channel
        channel = client.newChannel(Const.CHANNEL_NAME);

        //set peer
        peer = client.newPeer(PEER_DOMAIN_NAME,PEER_HOST,loadTLSFile(PEER_TLS_DIR,PEER_CLIENT_CERT,PEER_CLIENT_KEY,PEER_DOMAIN_NAME));//loadTLSFile();
        channel.addPeer(peer);


        //set orderer
        orderer = client.newOrderer(Const.ORDERER_DOMAIN_NAME,ORDERER_HOST,loadTLSFile(Const.ORDERER_TLS_DIR,Const.ORDERER_CLIENT_CERT,Const.ORDERER_CLIENT_KEY,Const.ORDERER_DOMAIN_NAME));//loadTLSFile();
        channel.addOrderer(orderer);

        channel.initialize();

        chaincodeID = ChaincodeID.newBuilder().setName(Const.CHAINCODE_NAME).build();

    }
    public String ReadStatus(String key) throws InvalidArgumentException, ProposalException
    {
        String[] args={key};
        return query(client,channel,chaincodeID,"query",args);
    }

    public boolean WriteStatus(String key, String val) throws ProposalException, InvalidArgumentException, ExecutionException, InterruptedException
    {
        String[] args={key,val};
        return invoke(client,channel,chaincodeID,"invoke",args);
    }

    public String ReadHistory(String key) throws InvalidArgumentException, ProposalException
    {
        String[] args={key};
        return query(client,channel,chaincodeID,"queryhistory",args);
    }
    public boolean DeleteStatus(String key) throws InterruptedException, InvalidArgumentException, ProposalException, ExecutionException {
        String[] args={key};
        return invoke(client,channel,chaincodeID,"delete",args);
    }

    public boolean Count(String key) throws InvalidArgumentException, ProposalException, ExecutionException, InterruptedException {
        String[] args={key};
        return invoke(client,channel,chaincodeID,"count",args);
    }
    public TradeRecord ReadTRStatus(String key) throws InvalidArgumentException, ProposalException {
        String[] args={key};
        String trs = query(client,channel,chaincodeID,"query",args);
        TradeRecord tr = JSON.parseObject(trs,TradeRecord.class);
        return tr;
    }
    public boolean WriteTRStatus(TradeRecord tr) throws InterruptedException, InvalidArgumentException, ProposalException, ExecutionException {
        String key = tr.getCrabId();
        String val = JSON.toJSONString(tr);
        String[] args={key,val};
        return invoke(client,channel,chaincodeID,"invoke",args);
    }
    public List<TradeRecord> ReadTRHistory(String key) throws InvalidArgumentException, ProposalException {
        String[] args={key};
        String trs = query(client,channel,chaincodeID,"queryhistory",args);
        List<TradeRecord> tr = JSONObject.parseArray(trs,TradeRecord.class);
        return tr;
    }
    private String query(HFClient client,Channel channel,ChaincodeID chaincodeID,String func,String[] args) throws ProposalException, InvalidArgumentException
    {
        QueryByChaincodeRequest req = client.newQueryProposalRequest();
        req.setChaincodeID(chaincodeID);
        req.setFcn(func);
        req.setArgs(args);

        String ret = null;
        Collection<ProposalResponse> queryResponse = channel.queryByChaincode(req);


        for (ProposalResponse pres : queryResponse)
        {
            ret = pres.getProposalResponse().getResponse().getPayload().toStringUtf8();
            //ret = pres.getProposalResponse().getResponse().getMessage();
            //System.out.println(ret);
        }
        return ret;
    }

    private boolean invoke(HFClient client,Channel channel,ChaincodeID chaincodeID,String func,String[] args) throws InvalidArgumentException, ProposalException, ExecutionException, InterruptedException
    {
        TransactionProposalRequest req = client.newTransactionProposalRequest();
        req.setChaincodeID(chaincodeID);
        req.setFcn(func);
        req.setArgs(args);
        req.setUserContext(fabUser);

        req.setProposalWaitTime(3000);

        Collection<ProposalResponse> rsp = channel.sendTransactionProposal(req);
        /*
        for(ProposalResponse pres : rsp)
        {
            System.out.println(pres.getProposalResponse().getResponse().getPayload().toStringUtf8());
        }
        */
        BlockEvent.TransactionEvent event = channel.sendTransaction(rsp).get();
        return event.isValid();
    }


    private static Properties loadTLSFile(String rootTLSCert,String clientCert,String clientKey,String hostname) throws IOException
    {
        Properties properties = new Properties();
        properties.put("pemBytes", Files.readAllBytes(Paths.get(Const.BASE_PATH + rootTLSCert)));
        properties.put("clientKeyBytes",Files.readAllBytes(Paths.get(Const.BASE_PATH + clientKey)));
        properties.put("clientCertBytes",Files.readAllBytes(Paths.get(Const.BASE_PATH + clientCert)));
        properties.setProperty("sslProvider","openSSL");
        properties.setProperty("negotiationType","TLS");
        properties.setProperty("trustServerCertificate","true");
        properties.setProperty("hostnameOverrider",hostname);
        return properties;
    }

}
