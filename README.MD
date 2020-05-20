/*
*
*	Author ： Bosh
*	Date   :  2020/5/11
*
*/


当前使用环境为Windows
//Linux用户请将Const类下的"getPath().substring(1);"去掉".substring(1);"


接口类名：FabricService
方法：
	Init(String userName,int Org,String serverHost) 返回类型：void 说明：在生成接口对象后请直接调用该方法。userName即注册的用户名；Org即身份编号，serverHost为Ubuntu的ip地址

	WriteTRStatus(TradeRecord tr) 返回类型：boolean
	说明：函数参数为TradeRecord，返回是否已经写入区块链中

	ReadTRStatus(String key) 返回类型：TradeRecord
	说明：读取最近的“key”(例如“00016”)这只螃蟹的记录，用于逻辑验证最近的记录的receiverCompany是否为当前用户的senderCompany

	ReadTRHistory(String key) 返回类型：List<TradeRecord>
	说明：读取“key”这只螃蟹的全部交易记录

	WriteStatus(String key, String val) 返回类型：boolean
	说明：更新“key”的value为val。暂时不需要，方便业务拓展

	DeleteStatus(String key) 返回类型：boolean
	说明：将“key”从区块链中删除，即删除“key”对应的world state。暂时不需要，方便业务拓展

	ReadStatus(String key) 返回类型：String
	说明：读取“key”的value。ReadTRStatus是ReadStatus的特例，即ReadStatus返回的value反序列化为一个TradeRecord。该方法暂时用于查询已卖出的螃蟹数。
	注意：若一个没卖出时，该方法返回一个空串“”，请用.equals("")方法判断。否则请将string转为int

	Count(String key) 返回类型：boolean
	说明：将“key”的value值加一，返回是否已写入区块链中。请在CrabSeller出库，也就是卖出螃蟹时调用该函数
	备注:orderer已将proposal按顺序打包，不会出现并发可能出现的问题


统一规范：
	一、crabid为“数字”，例："00016"为crabid为00016的螃蟹
	二、卖出螃蟹数量的键为"cnt"+"年份"，例"cnt2020"为2020年已卖出的螃蟹数量的键
	三、最初协会定下的螃蟹数量的键为"total"+"年份"，例"total2020"为2020年批准卖出的螃蟹数量的键
	四、身份编号请按：0管理员，1养殖户，2生产商，3运输商，4销售商对应。备注：养殖户目前不在业务逻辑当中，如果需要，则在协会
向生产商发起的TradeRecord的备注中添加养殖户姓名。如果需要，可以增加养殖户在某一年卖出的螃蟹数和审批的螃蟹数功能
	五、TradeRecord必须有下列成员，建议使用bosh.tech中的TradeRecord类方便统一

	private String crabId;//螃蟹id
    private double weight;//重量
    private boolean doa;//死活情况
    private Date time;//交易时间
    private String location;//交易地点：即当前用户的工作地点
    private String sender;//交易发出者：即当前用户的真实姓名
    private String senderCompany;
    private String receiverCompany;//交易接收者所属公司
    private String remark;//交易备注

    其中四，五两条若不统一，请在群中讨论，可能我这的版本比较落后
    实验的用户名请为：
    user1_association,user1_producer,user1_carrier,user1_seller
    user2_association,user2_producer,user2_carrier,user2_seller
    目前只生成了这八个用户的证书和密钥，见群文件resources.zip/
user。管理员证书和密钥不在此当中，在初始化方法中身份编号为0时，加载管理员密钥和证书，请客户端保证初始化方法时，身份编号不为0


依赖文件：
	群文件fabricservice_jar.zip为区块链接口包和依赖项包，导入到项目即可
	群文件resources.zip为证书和密钥，解压到项目的Resources文件夹即可



