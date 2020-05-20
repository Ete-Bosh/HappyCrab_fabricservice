package bosh.test;
import org.hyperledger.fabric.sdk.*;
import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.identity.X509Enrollment;
import org.hyperledger.fabric.sdk.security.CryptoPrimitives;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.util.Set;


public class FabUser implements User
{
    private String name;
    private String account;
    private String affiliation;
    private String mspId;
    private Set<String> roles;
    private Enrollment enrollment;

    private FabUser(){}
    FabUser(String tname,String tmspId,String KeyFile,String CertFile) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException, CryptoException {
        if((enrollment = loadKeyandCert(KeyFile,CertFile)) != null )
        {
            name = tname;
            mspId = tmspId;
        }
    }
    public String getName()
    {
        return name;
    }

    public Set<String> getRoles()
    {
        return roles;
    }

    public String getAccount()
    {
        return account;
    }

    public String getAffiliation()
    {
        return affiliation;
    }

    public Enrollment getEnrollment()
    {
        return enrollment;
    }

    public String getMspId()
    {
        return mspId;
    }



    private Enrollment loadKeyandCert(String KeyFile,String CertFile) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException, CryptoException {
        try {
            byte[] keyPem = Files.readAllBytes(Paths.get(Const.BASE_PATH + KeyFile));
            byte[] cerPem = Files.readAllBytes(Paths.get(Const.BASE_PATH + CertFile));
            CryptoPrimitives cryptoPrimitives = new CryptoPrimitives();
            PrivateKey privateKey = cryptoPrimitives.bytesToPrivateKey(keyPem);
            return new X509Enrollment(privateKey, new String(cerPem));
        }catch ( IOException | IllegalAccessException | InstantiationException | ClassNotFoundException | CryptoException e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
/*


 */