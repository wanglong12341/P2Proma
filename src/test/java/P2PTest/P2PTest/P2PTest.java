package P2PTest.P2PTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class P2PTest extends Dependents{
	public static Properties properties = null;
	public static String url = null;
	public static String url1 = null;
	public static String url2 = null;
	public static InputStreamReader in;
	@BeforeClass
	public void BeforeClass(){
		try {
			in = new InputStreamReader(new FileInputStream("p2p.properties"),
					"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		properties = new Properties();
		try {
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		url = (String) properties.get("url");
		url1 = (String) properties.get("url1");
		url2 = (String) properties.get("url2");
	}
  @Test
  public void f() {
	  Map<String, String> returnmap = new HashMap<String, String>();
		try {
			Map f4 = f4();
			if (!f4.isEmpty()) {
				String customerId = f4.get("customerId").toString();
				String idCardNum = f4.get("idCardNum").toString();
				String mobile = f4.get("mobile").toString();
				String js = properties.getProperty("tuisong");
				Map jsmap = returnmap(js);
				jsmap.put("customerId", customerId);
				String json = mapTostring(jsmap);
				String [] strings = new String[5];
				strings[0]="API_CREATE_ITEM";
				strings[1]=getrequestNum();
				strings[2]="ROMA";
				strings[3]="20190408152211";
				strings[4]=json;
				
				String post2 = post2(url1, strings);
				System.out.println(post2);
				Map tuisong = returnmap(post2);
				Map res = returnmap(tuisong.get("responseData").toString());
				String itemId = res.get("itemId").toString();
				returnmap.put("customerId", customerId);
				returnmap.put("idCardNum", idCardNum);
				returnmap.put("mobile", mobile);
				returnmap.put("itemId", itemId);
			} else {
				returnmap.put("错误", "授信失败，请重试");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		System.out.println(mapTostring(returnmap));
  }
	public static Map sq() throws IOException, InterruptedException {
		Map<String, String> returnmap = new HashMap<String, String>();
		Map zc = zc();
		Thread.sleep(5000);
		String[] strings = new String[5];
		strings[0] = "API_CREDIT";
		strings[1] = getrequestNum();
		strings[2] = "ROMA";
		strings[3] = "20190408152211";
		String js = properties.getProperty("shouxin");
		Map map1 = returnmap(js);
		map1.put("customerId", zc.get("customerId"));

		Map personalInfo = returnmap(map1.get("personalInfo").toString());
		String bankNum = getJsbankno();
		String realName = getName();
		String idCardNum = getJsIdcardNO();
		personalInfo.put("bankNum", bankNum);
		personalInfo.put("realName", realName);
		personalInfo.put("idCardNum", idCardNum);
		personalInfo.put("mobile", zc.get("mobile"));

		map1.put("personalInfo", personalInfo);
		strings[4] = mapTostring(map1);
		System.out.println("444444444" + strings[4]);
		// String json1 = properties.getProperty("json1");

		String post2 = post2(url1, strings);
		Map mappost = returnmap(post2);
		Map responseData = returnmap(mappost.get("responseData").toString());
		String errorCode = responseData.get("errorCode").toString();
		// assertEquals(errorCode, "0000");
		System.out.println("@@@@@@@@@@@@@@@@@@@@" + post2);
		returnmap.put("customerId", zc.get("customerId").toString());
		returnmap.put("realName", realName);
		returnmap.put("idCardNum", idCardNum);
		returnmap.put("mobile", zc.get("mobile").toString());
		returnmap.put("bankNum", bankNum);
		returnmap.put("errorCode", errorCode);
		return returnmap;
	}

	public static Map zc() throws IOException {
		Map<String, String> map1 = new HashMap<String, String>();
		String phonenum = getPhonenm();
		String js = properties.getProperty("zhuce");
		Map map = returnmap(js);
		map.put("mobile", phonenum);
		String json = mapTostring(map);
		String[] strings = new String[5];
		strings[0] = "API_REGIST";
		strings[1] = getrequestNum();
		strings[2] = "ROMA";
		strings[3] = "20190408152211";
		strings[4] = json;

		// String json1 = properties.getProperty("json1");
		String post2 = post2(url1, strings);
		System.out.println(post2);
		Map map2 = returnmap(post2);
		System.out.println("注册成功");
		Map responseData = returnmap(map2.get("responseData").toString());
		String customerId = responseData.get("customerId").toString();

		map1.put("mobile", phonenum);
		map1.put("customerId", customerId);
		System.out.println("mobile:" + phonenum + "@" + "customerId:"
				+ customerId);
		return map1;
	}

	// 注册，授信，绑卡
	public static Map f4() throws IOException, InterruptedException {
		Map<String, String> returnmap = new HashMap<String, String>();
		Map sq = sq();
		
		String bankNum = sq.get("bankNum").toString();
		// System.out.println("bankNumbankNumbankNumbankNumbankNum"+bankNum);
		String realName = sq.get("realName").toString();
		String idCardNum = sq.get("idCardNum").toString();
		String mobile = sq.get("mobile").toString();
		String customerId = sq.get("customerId").toString();
		String errorCode = sq.get("errorCode").toString();
		if ("0000".equals(errorCode)) {
			String js = properties.getProperty("kaihu");
			Map mapjs = returnmap(js);
			mapjs.put("customerId", customerId);
			mapjs.put("realName", realName);
			mapjs.put("idCardNum", idCardNum);
			mapjs.put("mobile", mobile);
			String aft = mapTostring(mapjs);
			String[] strings = new String[5];
			strings[0] = "API_PERSONAL_REGIST_EXPAND";
			strings[1] = getrequestNum();
			strings[2] = "ROMA";
			strings[3] = "20190408152211";
			strings[4] = aft;
			System.out.println("aftttttttttttttt" + strings[4]);
			Thread.sleep(5000);
			String post2 = post2(url2, strings);
			System.out.println(post2);
			writeFile(post2);
			System.out.println("写入文件成功");
			bk();
			System.out.println("绑卡成功");
			returnmap.put("customerId", customerId);
			returnmap.put("realName", realName);
			returnmap.put("idCardNum", idCardNum);
			returnmap.put("mobile", mobile);	
		}else{
			returnmap.put("error", "授信失败，请重试");
		}
		
		return returnmap;

	}
//	@Test
//	public void get11() throws IOException{
//		writeFile("1212");
//	}
}
