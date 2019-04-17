package P2PTest.P2PTest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import bsh.StringUtil;










//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import net.sf.json.JSONObject;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableWorkbook;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Dependents {
	private static int i = 0;
	public static final String NUMBERCHAR = "0123456789";
	public static Workbook workbook = null;
	public static WritableWorkbook wwb = null;
	static OkHttpClient client = new OkHttpClient();
	public static final MediaType JSON = MediaType
			.parse("application/json; charset=utf-8");
	public static final MediaType JSON1 = MediaType
			.parse("application/x-www-form-urlencoded; charset=utf-8");
	// 用力集合
	public static ArrayList alldata = null;
	public static ArrayList<String> evdata = null;

	// 入参为测试地址路径，和json的参数形式，同步传输
	public static String post(String url, String json) throws IOException {
		RequestBody body = RequestBody.create(JSON, json);
		Request request = new Request.Builder()
				.addHeader("X-TBC-SOURCE", "tbc_zhtb_czb")
				.addHeader("X-TBC-SIGN", "").url(url).post(body).build();
		Response response = client.newCall(request).execute();
		String result = response.body().string();
		// 结果返回为字符串
		return result;
	}

	// 入参为测试地址路径 ，普通表单的参数形式，同步传输
	public static String post2(String url, String... strings)
			throws IOException {
		RequestBody body = new FormBody.Builder()
				.add("serviceName", strings[0].toString())
				.add("requestNum", strings[1].toString())
				.add("appId", strings[2].toString())
				.add("requestTime", strings[3].toString()).add("sign", "")
				.add("ext", "").add("requestData", strings[4].toString())
				.build();
		Request request = new Request.Builder()
				.header("Content-Type", "application/x-www-form-urlencoded")
				.url(url).post(body).build();
		Response response = client.newCall(request).execute();
		String result = response.body().string();
		// 结果返回为字符串
		return result;
	}

	// 入参为测试地址路径，和json的参数形式，同步传输
	public static String post1(String url, String json) throws IOException {
		RequestBody body = RequestBody.create(JSON, json);
		Request request = new Request.Builder().url(url).post(body).build();
		Response response = client.newCall(request).execute();
		String result = response.body().string();
		// 结果返回为字符串
		return result;
	}

	// GET方法
	public static String get(String url) throws IOException {
		OkHttpClient client = new OkHttpClient();
		String result = null;
		Request request = new Request.Builder().url(url).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	// 生成手机号
	public static String getPhonenm() {
		StringBuilder str = new StringBuilder("");
		Random random = new Random();
		// 随机生成数字，并添加到字符串
		for (int i = 0; i < 8; i++) {
			str.append(random.nextInt(10));
		}
		String phnum = "150" + str;
		return phnum;

	}

	// 生成sourceUserId
	public static String getsourceUserId() {
		StringBuilder str = new StringBuilder("");
		Random random = new Random();
		// 随机生成数字，并添加到字符串
		for (int i = 0; i < 4; i++) {
			str.append(random.nextInt(10));
		}

		return str.toString();

	}

	// 生成bankCardNo
	public static String getbankCardNo() {
		StringBuilder str = new StringBuilder("");
		Random random = new Random();
		// 随机生成数字，并添加到字符串
		for (int i = 0; i < 8; i++) {
			str.append(random.nextInt(10));
		}
		String bankCardNo = "62226666" + str;
		return bankCardNo;

	}

	// 生成bankCardNo
	public static String getcraditCardNum() {
		StringBuilder str = new StringBuilder("");
		Random random = new Random();
		// 随机生成数字，并添加到字符串
		for (int i = 0; i < 11; i++) {
			str.append(random.nextInt(10));
		}
		String bankCardNo = "62226666" + str;
		return bankCardNo;

	}

	// 51生成creditApplyNo
	public static String getcreditApplyNo() {
		StringBuilder str = new StringBuilder("");
		Random random = new Random();
		// 随机生成数字，并添加到字符串
		for (int i = 0; i < 10; i++) {
			str.append(random.nextInt(10));
		}

		return str.toString();

	}

	// 51生成productId
	public static String getproductId() {
		StringBuilder str = new StringBuilder("");
		Random random = new Random();
		// 随机生成数字，并添加到字符串
		for (int i = 0; i < 5; i++) {
			str.append(random.nextInt(10));
		}
		String productId = "channel" + str;
		return productId;

	}

	// 51生成requestNum
	public static String getrequestNum() {
		StringBuilder str = new StringBuilder("");
		Random random = new Random();
		// 随机生成数字，并添加到字符串
		for (int i = 0; i < 6; i++) {
			str.append(random.nextInt(10));
		}
		String requestNum = "51CARDno" + str;
		return requestNum;

	}

	// czb 生成transactionId
	public static String gettransactionId() {
		StringBuilder str = new StringBuilder("");
		Random random = new Random();
		// 随机生成数字，并添加到字符串
		for (int i = 0; i < 4; i++) {
			str.append(random.nextInt(10));
		}
		String transactionId = "Test_" + str;
		return transactionId;

	}

	public static ArrayList readExcel(String path) {
		InputStream in = null;
		alldata = new ArrayList();
		evdata = new ArrayList<String>();
		String[] str = null;
		try {

			// 读取输入流
			in = new FileInputStream(path);
			workbook = Workbook.getWorkbook(in);
			// 读取sheet页默认从第一页开始
			Sheet s1 = workbook.getSheet(0);
			// Sheet s2 = readwb.getSheet("");
			// 读取列数
			int columns = s1.getColumns();
			// System.out.println("lieshu:" + columns);
			// 读取行数
			int rows = s1.getRows();
			// System.out.println("行數：" + rows);
			for (int i = 2; i < rows; i++) {
				str = new String[3];
				// for (int j = 1; j < columns; j++) {
				// if(j==1 || j==3 || j==4){

				Cell cell1 = s1.getCell(1, i);
				// System.out.print(cell1.getContents() + " ");
				if (cell1.getContents() != "") {
					str[0] = cell1.getContents();
				}
				Cell cell3 = s1.getCell(3, i);
				if (cell3.getContents() != "") {
					str[1] = cell3.getContents();
				}
				// System.out.print(cell3.getContents() + " ");
				Cell cell4 = s1.getCell(4, i);
				if (cell4.getContents() != "") {
					str[2] = cell4.getContents();
					// System.out.print(cell4.getContents() + " ");
				}
				alldata.add(str);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				// System.out.println("closed inputstream");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// System.out.println("读取测试用例完成");
		// System.out.println(alldata.size());
		return alldata;
	}

	// 通过js获取身份证号
	public static String getJsIdcardNO() {
		String idcrd = null;
		// 创建一个脚本引擎管理器
		ScriptEngineManager manager = new ScriptEngineManager();
		// 获取一个指定的名称的脚本引擎
		ScriptEngine engine = manager.getEngineByName("js");
		try {
			// 获取当前类的所在目录的路径
			String path = Dependents.class.getResource("").getPath();
			// FileReader的参数为所要执行的js文件的路径
			engine.eval(new FileReader("guding.js"));
			if (engine instanceof Invocable) {
				Invocable invocable = (Invocable) engine;
				idcrd = (String) invocable.invokeFunction("getIdNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idcrd;

	}

	// 通过js获取銀行号
	public static String getJsbankno() {
		String idcrd = null;
		// 创建一个脚本引擎管理器
		ScriptEngineManager manager = new ScriptEngineManager();
		// 获取一个指定的名称的脚本引擎
		ScriptEngine engine = manager.getEngineByName("js");
		try {
			// 获取当前类的所在目录的路径
			String path = Dependents.class.getResource("").getPath();
			// FileReader的参数为所要执行的js文件的路径
			engine.eval(new FileReader("bk.js"));
			if (engine instanceof Invocable) {
				Invocable invocable = (Invocable) engine;
				idcrd = (String) invocable.invokeFunction("getBankAccount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idcrd;

	}

	// 获取新的身份信息
	public static Map getUserinfo() throws InterruptedException {
		Map<String, String> map = new HashMap<String, String>();
		System.setProperty("webdriver.chrome.driver", "d:\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		// 设置 chrome 的无头模式
		chromeOptions.setHeadless(Boolean.TRUE);
		// 启动一个 chrome 实例
		WebDriver driver = new ChromeDriver(chromeOptions);
		// WebDriver driver = new HtmlUnitDriver();
		// Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.get("http://jsrun.net/7shKp/detail");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//iframe"));
		Thread.sleep(2000);
		driver.findElement(By.tagName("iframe"));
		Thread.sleep(2000);
		String nameid = driver
				.findElement(
						By.cssSelector("#list > table > tbody > tr:nth-child(3) > td:nth-child(1)"))
				.getText();
		String id = driver
				.findElement(
						By.cssSelector("#list > table > tbody > tr:nth-child(3) > td:nth-child(2)"))
				.getText();
		// String[] nameId = nameid.split(" ");
		// String name = nameId[0];
		// String idno = nameId[1];
		driver.quit();
		map.put("custName", nameid);
		map.put("cardNum", id);
		// map.put("sex", sex);
		return map;
	}

	// 把String 结果转换为Map
	public static Map returnmap(String str) {
		// Map<String, Object> map =
		// com.alibaba.fastjson.JSON.parseObject(str,Map.class);
		// Map<String, Object> map =
		// FastJsonConfig.JSON.parseObject(str,Map.class);
		com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject
				.parseObject(str);
		// System.out.println(jsonObject.toString());
		Map<String, Object> map = (Map<String, Object>) jsonObject;
		return map;
	}

	public static Connection getConn() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://39.106.164.42:9919/51card";
		String username = "root";
		String password = "dJ_xw2ve_Dc9_1OiY3";
		Connection conn = null;
		try {
			Class.forName(driver); // classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(url, username,
					password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static int insert(String sql) {
		Connection conn = getConn();
		int i = 0;

		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	// map zhuan string
	public static String mapTostring(Map map) {
		JSONObject jsonObject = JSONObject.fromObject(map);
		return jsonObject.toString();
	}

	public static String getName() {
		Random random = new Random();
		String firstname = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯昝管卢莫经房裘缪干解应宗丁宣贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄曲家封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘景詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲邰从鄂索咸籍赖卓蔺屠蒙池乔阴鬱胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍卻璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庾终暨居衡步都耿满弘匡国文寇广禄阙东欧殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后荆红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于单于太叔申屠公孙仲孙轩辕令狐钟离宇文长孙慕容鲜于闾丘司徒司空丌官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓跋夹谷宰父谷梁晋楚闫法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况郈有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟";
		String names = "子璇淼国栋夫子瑞堂甜敏尚国贤贺祥晨涛昊轩易轩辰益帆冉瑾春瑾昆春齐杨文昊东雄霖浩晨熙涵溶溶冰枫欣宜豪欣慧建政美欣淑慧文轩杰欣源忠林榕润欣汝慧嘉新建建林亦菲林冰洁佳欣涵涵禹辰淳美泽惠伟洋涵越润丽翔淑华晶莹凌晶苒溪雨涵嘉怡佳毅子辰佳琪紫轩瑞辰昕蕊萌明远欣宜泽远欣怡佳怡佳惠晨茜晨璐运昊汝鑫淑君晶滢润莎榕汕佳钰佳玉晓庆一鸣语晨添池添昊雨泽雅晗雅涵清妍诗悦嘉乐晨涵天赫玥傲佳昊天昊萌萌若萌测试身份证号大全和名由程序随机组合而成所有信息均为虚构生成不会泄密真实公民隐私信息也非现实生活中真实的身份证号码和真实名身份证号码所属年龄均为岁以上均已通过校验身份证号码和名仅供测试或用在必须输入身份证号码和名的网站上请不要将身份证号码和名用于任何非法用途且自行承担使用本工具的任何后果和责任";

		int a = random.nextInt(firstname.length());
		int b = random.nextInt(names.length());
		int c = random.nextInt(names.length());
		System.out.println(a + ":" + b + ":" + c);
		String fname = firstname.substring(Math.abs(a), Math.abs(a) + 1);
		String nname1 = names.substring(Math.abs(b), Math.abs(b) + 1);
		String nname2 = names.substring(Math.abs(c), Math.abs(c) + 1);
		String name = fname + nname1 + nname2;

		return name;
	}

	// 写入文件
	public static void writeFile(String s) throws IOException {
		
//		String path = Dependents.class.getClassLoader().getResource("a.html").getPath();
//		String path = Dependents.class.getClassLoader().getResource("a.html").getPath();
//		System.out.println("");
		File file = new File("./src/test/java/a.html");
		FileWriter fw = new FileWriter(file); // 设置成true就是追加
		fw.write(s);
		fw.close();
	}
	//进行绑卡
	public static void bk() throws IOException, InterruptedException{
//		ChromeDriverService service = new ChromeDriverService.Builder() .usingDriverExecutable(new File("D:\\chromedriver.exe")).usingAnyFreePort().build();
//		service.start();
	
		
//		String path = P2PTest.class.getResource("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
//		 设置 chrome 的无头模式
		chromeOptions.setHeadless(Boolean.TRUE);
//		 启动一个 chrome 实例
		WebDriver driver = new ChromeDriver(chromeOptions);
//		WebDriver driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
		Thread.sleep(2000);
		driver.manage().window().maximize();
		String path = Dependents.class.getClassLoader().getResource("a.html").getPath();
		System.out.println(path);
		driver.get("file://"+path);
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1400)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"sendSmsVerify\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"alertLayer\"]/div[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"smsCode\"]")).sendKeys("111111");
		Thread.sleep(2000);
//		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 2500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("111111");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]")).sendKeys("111111");
		Thread.sleep(2000);
//		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 3500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[11]/div[3]/div/label/i[1]/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"nextButton\"]")).click();
		Thread.sleep(2000);
		driver.quit();
		// 关闭 ChromeDriver 接口
//		service.stop();
	}

	public static void main(String[] args) throws IOException,
			InterruptedException {
//		ChromeDriverService service = new ChromeDriverService.Builder() .usingDriverExecutable(new File("D:\\chromedriver.exe")).usingAnyFreePort().build();
//		service.start();
//	
		

//		System.setProperty("webdriver.chrome.driver", "d:\\chromedriver.exe");
//		ChromeOptions chromeOptions = new ChromeOptions();
		// 设置 chrome 的无头模式
//		chromeOptions.setHeadless(Boolean.TRUE);
		// 启动一个 chrome 实例
//		WebDriver driver = new ChromeDriver(chromeOptions);
//		 WebDriver driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
//		Thread.sleep(2000);
//		driver.manage().window().maximize();
//		driver.get("file:///D:/a.html");
//		Thread.sleep(2000);
//		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1400)");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"sendSmsVerify\"]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"alertLayer\"]/div[2]/a")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"smsCode\"]")).sendKeys("111111");
//		Thread.sleep(2000);
////		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 2500)");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("111111");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]")).sendKeys("111111");
//		Thread.sleep(2000);
////		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 3500)");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"form\"]/div[11]/div[3]/div/label/i[1]/img")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"nextButton\"]")).click();
//		Thread.sleep(2000);
//		driver.quit();
//		// 关闭 ChromeDriver 接口
//		service.stop();
		writeFile("111");
	}
	// String a = "\"\"";

}
