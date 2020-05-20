package bosh.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class FabricServiceTest {

    @Test
    public  void setup1()throws  Exception
    {
        FabricService fs1 = new FabricService();
        fs1.Init("user1_association",1,"192.168.1.108");
        TradeRecord a = new TradeRecord("00016",3.01,true,new Date(),"Yangchenghu","farmer1","Association","SEU","");
        fs1.WriteTRStatus(a);
    }
    @Test
    public  void setup2()throws  Exception
    {
        FabricService fs2 = new FabricService();
        fs2.Init("user1_producer",2,"192.168.1.108");
        TradeRecord b = new TradeRecord("00016",3.01,true,new Date(),"Changchun","bosh","SEU","JLU","");
        fs2.WriteTRStatus(b);
    }
    @Test
    public  void setup3()throws  Exception
    {
        FabricService fs3 = new FabricService();
        fs3.Init("user1_carrier",3,"192.168.1.108");
        TradeRecord c = new TradeRecord("00016",3.00,true,new Date(),"Jilin","maou","JLU","PSU","");
        fs3.WriteTRStatus(c);
    }
    @Test
    public  void setup4()throws  Exception
    {
        FabricService fs3 = new FabricService();
        fs3.Init("user1_carrier",3,"192.168.1.108");
        TradeRecord tr = fs3.ReadTRStatus("00016");
        System.out.println(tr.getCrabId());
        System.out.println(tr.getWeight());
        System.out.println(tr.getDoa());
        System.out.println(tr.getTimeString());
        System.out.println(tr.getLocation());
        System.out.println(tr.getSender());
        System.out.println(tr.getSenderCompany());
        System.out.println(tr.getReceiver());
        System.out.println(tr.getRemark());
        System.out.println("\n");


    }
    @Test
    public  void setup5()throws  Exception
    {
        FabricService fs4 = new FabricService();
        fs4.Init("user1_seller",4,"192.168.1.108");
        TradeRecord d = new TradeRecord("00016",3.01,true,new Date(),"Panshi","storm","PSU","Mr.Wan","13756568515");
        fs4.WriteTRStatus(d);
    }
    @Test
    public  void setup15()throws  Exception
    {
        FabricService fs4 = new FabricService();
        fs4.Init("user1_association",4,"192.168.1.108");
        TradeRecord d = new TradeRecord("00016",3.01,true,new Date(),"Panshi","storm","PSU","Mr.Wan","13756568515");
        fs4.WriteTRStatus(d);
    }
    @Test
    public  void setup6()throws  Exception
    {
        FabricService fs1 = new FabricService();
        fs1.Init("admin",0,"192.168.1.108");
        List<TradeRecord> ltr = fs1.ReadTRHistory("00016");
        for (TradeRecord tr : ltr) {
            System.out.println(tr.getCrabId());
            System.out.println(tr.getWeight());
            System.out.println(tr.getDoa());
            System.out.println(tr.getTimeString());
            System.out.println(tr.getLocation());
            System.out.println(tr.getSender());
            System.out.println(tr.getSenderCompany());
            System.out.println(tr.getReceiver());
            System.out.println(tr.getRemark());
        }

    }
    @Test
    public void setup7()throws Exception
    {
        FabricService fs4 = new FabricService();
        fs4.Init("user1_seller",4,"192.168.1.108");
        System.out.println(fs4.ReadStatus("cnt2020"));
        if(fs4.ReadStatus("cnt2020").equals(""))
        {
            System.out.println("TRUE");
        }

        fs4.Count("cnt2020");
        System.out.println(fs4.ReadStatus("cnt2020"));
        fs4.Count("cnt2020");
        fs4.Count("cnt2020");
        System.out.println(fs4.ReadStatus("cnt2020"));
    }

    public void setup30() throws Exception
    {
        FabricService fs = new FabricService();
       // FabricService fs2 = new FabricService();
       //FabricService fs3 = new FabricService();
        //FabricService fs4 = new FabricService();
       /* TradeRecord a = new TradeRecord("00012",3.01,true,new Date(),"Yangchenghu","farmer1","Association","SEU","");
        TradeRecord b = new TradeRecord("00012",3.01,true,new Date(),"Changchun","bosh","SEU","JLU","");
        TradeRecord c = new TradeRecord("00012",3.00,true,new Date(),"Jilin","maou","JLU","PSU","");
        TradeRecord d = new TradeRecord("00012",3.01,true,new Date(),"Panshi","storm","PSU","Mr.Wan","13756568515");
*/
        fs.Init("admin",0,"192.168.1.108");

        System.out.println(fs.ReadStatus("a"));
        //fs2.Init(2);
        //fs3.Init(3);
        //fs4.Init(4);
        //fs3.WriteTRStatus(c);
        //fs4.WriteTRStatus(d);
        /*fs.WriteStatus("a","string1");
        fs.WriteStatus("a","string2");
        System.out.println(fs.ReadStatus("a"));
        fs.DeleteStatus("a");
        System.out.println(fs.ReadStatus("a"));
        System.out.println(fs.ReadHistory("a"));
        */
/*


        fs.WriteTRStatus(b);
        fs.WriteTRStatus(c);
        fs.WriteTRStatus(d);
        System.out.println(fs.ReadHistory("00012"));
        List<TradeRecord> ltr = fs.ReadTRHistory("00012");
        for (TradeRecord tr : ltr) {
            System.out.println(tr.getCrabId());
            System.out.println(tr.getWeight());
            System.out.println(tr.getDoa());
            System.out.println(tr.getTime());
            System.out.println(tr.getLocation());
            System.out.println(tr.getSender());
            System.out.println(tr.getSenderCompany());
            System.out.println(tr.getReceiver());
            System.out.println(tr.getRemark());
            System.out.println("\n");
        }


*/

        /*
        fs.WriteStatus("id0001","jsonstring1");
        fs.ReadStatus("id0001");
        fs.WriteStatus("id0001","jsonstring2");
        fs.WriteStatus("id0001","jsonstring3");
        fs.WriteStatus("id0001","jsonstring4");
        fs.ReadStatus("id0001");
        fs.ReadHistory("id0001");
        */
    }

}
