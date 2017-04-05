package com.example.lining.payment_.pay;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.alipay.sdk.app.PayTask;
import com.example.lining.payment_.R;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class PayDemoActivity extends FragmentActivity {

	// 商户PID
	public static final String PARTNER = "2088901305856832";
	// 商户收款账号
	public static final String SELLER = "8@qdbaiu.com";
	// 商户私钥，pkcs8格式
	public static final String RSA_PRIVATE ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCUCzFVQHJlT1muHsiio5qropzY6JgDga2YnFlLttbkI7wvfvr2ndqackp2R4HF1HSCzwxe5PcMtvDNNHkDbf4SWDYDKtRW3ruXjOOb8799FdSSLayX3URaff7huJWdxuVH+K+C9LwguFJtxtlGvo/Dw1TCi260nYRYtBt3rKjFHbS5KF5n0WYMrQJPiJEiwApXsrLlVReAXXnAsgixa7apnBPMNQHQ4RscboE+1DRwQNJRanWFA3+ffPAibcnXKyXGONOOkgFZ29iwOgCQ9I8ix0BtfKsXrPXk0GQbhij+q5BdTE/Zjh2sOmbqpFvSXNN/wQcNMzNgmFpmLoRsTrnvAgMBAAECggEAI8gQxGovPA1Rv6PxGl4wpAtJnaOaGj7dlmUzr/khN0Lr2Q732WON0oaNOMlPtGEFSBiDBOySSaBt0ys7lHihUA3CAEH50IVFEfwbhzYCslj0Z+BiNtJkEvsg/619fAT2pc6VnTFJxx7FzYKiQVcNqGMtuVe6Ci2IL2hYuzQgFoQZFih+n8R1IHcTwcv7Ht8OYNrpxrMIIUUhFVPZvXJiSO4qkE7Nd4KoLqImYa9wUGkpGG4bHlNy8urKm+s8Bj6WjVSoN0qOFyGuVW9VORV4dOHRm7k1x73j2ityVHDcAhIwX416Ja8Ego4XDL2lDQFI1sU2KRCClqIJA8x77wmXAQKBgQDUHWF8uXRFpkKvpiEP/Yrx/b2++xWXfTETnLjhic+1oBl+sz/Zbzn+9B9jVkvM6UJg0fRpUU1gu7yw846bgKoue7Un3NsLT9vN5Ue0/lX3YSZiWWAYIcGDbmRTtsIVQAhQR0D4GKa/malEX+eRq7puMhkH69VAlk7/56KgaSJgQwKBgQCyrE0CpYWlO89cmmkbFk20iedVommrIHAcRkkSMDSS9I6t8kboJm9Cqngmo2V2hxlw9HvwEuTncwtG1QxOHrx+FIwdR2Qga32gZiK8soLmMvtEhK4iM6mUNQLgTGhFmrkwzShn/kyRgXVPnpKcd7pZiWvLsxoCtQH9TyLovUQK5QKBgQDKEy+Dph4qGGmhctA+rpoHTmfNIOECECeH+p97ZlH2Qw7m0Je8aqVCyYl5loXiMjqliH+jMexYgqIRpgavCFWYsQv1bQdU8ICD17GHsWFuqiPqQCE2/DmiH7H+uraNjhIdgLRZZwq8sAQ8+mzfL04NmzaTgE4KGOgsDZ212lMAhwKBgFOl6t/kUi9LUwdNmwt9Y5+0OEOVJ9df9lymYytKujJaoDm7hYrGA6y4Vkvwj13wXe7N5wA8OEJLT+o3b+1a4nA8emRyueObr1LavkSNZk8TayNm4odMnIWwU8piuyZrC2xXgCU/nuU4MI239XefbfThK0BQd0rxJx9KX1OK2EIpAoGBAL1k33+Wd6MWy+QhPu+vVSuic83NPox8DNyH72/pa0WmwFfStePUdvTQ5kikktZ7ztwKfkE530ghTILZ5mZvHz7sy/8EeePc+SxZKudI9aqgCMURr4g8xN+V1hN6k0Dfc5AI92ej5/rljUqF8lPnqdmXduV4ExOsr+XnwxBYYR0D";
	// 支付宝公钥
	public static final String RSA_PUBLIC = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlAsxVUByZU9Zrh7IoqOaq6Kc2OiYA4GtmJxZS7bW5CO8L3769p3amnJKdkeBxdR0gs8MXuT3DLbwzTR5A23+Elg2AyrUVt67l4zjm/O/fRXUki2sl91EWn3+4biVncblR/ivgvS8ILhSbcbZRr6Pw8NUwotutJ2EWLQbd6yoxR20uSheZ9FmDK0CT4iRIsAKV7Ky5VUXgF15wLIIsWu2qZwTzDUB0OEbHG6BPtQ0cEDSUWp1hQN/n3zwIm3J1yslxjjTjpIBWdvYsDoAkPSPIsdAbXyrF6z15NBkG4Yo/quQXUxP2Y4drDpm6qRb0lzTf8EHDTMzYJhaZi6EbE657wIDAQAB";
	private static final int SDK_PAY_FLAG = 1;

	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler() {
		@SuppressWarnings("unused")
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SDK_PAY_FLAG: {
				PayResult payResult = new PayResult((String) msg.obj);
				/**
				 * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
				 * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
				 * docType=1) 建议商户依赖异步通知
				 */
				String resultInfo = payResult.getResult();// 同步返回需要验证的信息

				String resultStatus = payResult.getResultStatus();
				// 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
				if (TextUtils.equals(resultStatus, "9000")) {
					Toast.makeText(PayDemoActivity.this, "支付成功",
							Toast.LENGTH_SHORT).show();
				} else {
					// 判断resultStatus 为非"9000"则代表可能支付失败
					// "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
					if (TextUtils.equals(resultStatus, "8000")) {
						Toast.makeText(PayDemoActivity.this, "支付结果确认中",
								Toast.LENGTH_SHORT).show();
					} else {
						// 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
						Toast.makeText(PayDemoActivity.this, "支付失败",
								Toast.LENGTH_SHORT).show();

					}
				}
				break;
			}
			default:
				break;
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pay_main);
	}

	/**
	 * call alipay sdk pay. 调用SDK支付
	 * 
	 */
	public void pay(View v) {
		if (TextUtils.isEmpty(PARTNER) || TextUtils.isEmpty(RSA_PRIVATE)
				|| TextUtils.isEmpty(SELLER)) {
			new AlertDialog.Builder(this)
					.setTitle("警告")
					.setMessage("需要配置PARTNER | RSA_PRIVATE| SELLER")
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {
								public void onClick(
										DialogInterface dialoginterface, int i) {
									//
									finish();
								}
							}).show();
			return;
		}
		//----客户端--订单字符串
		String orderInfo = getOrderInfo("测试的商品", "该测试商品的详细描述", "0.01");

		/**
		 * 特别注意，这里的签名逻辑需要放在服务端，切勿将私钥泄露在代码中！
		 * 
		 * 这一行代码-----服务端
		 */
		String sign = sign(orderInfo);
		try {
			/**
			 * 仅需对sign 做URL编码
			 */
			sign = URLEncoder.encode(sign, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		/**
		 * 完整的符合支付宝参数规范的订单信息
		 */
		final String payInfo = orderInfo + "&sign=\"" + sign + "\"&"
				+ getSignType();

		Runnable payRunnable = new Runnable() {

			@Override
			public void run() {
				// 构造PayTask 对象
				PayTask alipay = new PayTask(PayDemoActivity.this);
				// 调用支付接口，获取支付结果
				String result = alipay.pay(payInfo, true);

				Message msg = new Message();
				msg.what = SDK_PAY_FLAG;
				msg.obj = result;
				mHandler.sendMessage(msg);
			}
		};

		// 必须异步调用
		Thread payThread = new Thread(payRunnable);
		payThread.start();
	}

	/**
	 * get the sdk version. 获取SDK版本号
	 * 
	 */
	public void getSDKVersion() {
		PayTask payTask = new PayTask(this);
		String version = payTask.getVersion();
		Toast.makeText(this, version, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 原生的H5（手机网页版支付切natvie支付） 【对应页面网页支付按钮】
	 * 
	 * @param v
	 */
	public void h5Pay(View v) {
		Intent intent = new Intent(this, H5PayDemoActivity.class);
		Bundle extras = new Bundle();
		/**
		 * url是测试的网站，在app内部打开页面是基于webview打开的，demo中的webview是H5PayDemoActivity，
		 * demo中拦截url进行支付的逻辑是在H5PayDemoActivity中shouldOverrideUrlLoading方法实现，
		 * 商户可以根据自己的需求来实现
		 */
		String url = "http://m.taobao.com";
		// url可以是一号店或者淘宝等第三方的购物wap站点，在该网站的支付过程中，支付宝sdk完成拦截支付
		extras.putString("url", url);
		intent.putExtras(extras);
		startActivity(intent);
	}

	/**
	 * create the order info. 创建订单信息
	 * 
	 */
	private String getOrderInfo(String subject, String body, String price) {

		// 签约合作者身份ID
		String orderInfo = "partner=" + "\"" + PARTNER + "\"";

		// 签约卖家支付宝账号
		orderInfo += "&seller_id=" + "\"" + SELLER + "\"";

		// 商户网站唯一订单号
		orderInfo += "&out_trade_no=" + "\"" + getOutTradeNo() + "\"";

		// 商品名称
		orderInfo += "&subject=" + "\"" + subject + "\"";

		// 商品详情
		orderInfo += "&body=" + "\"" + body + "\"";

		// 商品金额
		orderInfo += "&total_fee=" + "\"" + price + "\"";

		// 服务器异步通知页面路径
		orderInfo += "&notify_url=" + "\"" + "http://notify.msp.hk/notify.htm"
				+ "\"";

		// 服务接口名称， 固定值
		orderInfo += "&service=\"mobile.securitypay.pay\"";

		// 支付类型， 固定值
		orderInfo += "&payment_type=\"1\"";

		// 参数编码， 固定值
		orderInfo += "&_input_charset=\"utf-8\"";

		// 设置未付款交易的超时时间
		// 默认30分钟，一旦超时，该笔交易就会自动被关闭。
		// 取值范围：1m～15d。
		// m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
		// 该参数数值不接受小数点，如1.5h，可转换为90m。
		orderInfo += "&it_b_pay=\"30m\"";

		// extern_token为经过快登授权获取到的alipay_open_id,带上此参数用户将使用授权的账户进行支付
		// orderInfo += "&extern_token=" + "\"" + extern_token + "\"";

		// 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
		orderInfo += "&return_url=\"m.alipay.com\"";

		return orderInfo;
	}

	/**
	 * get the out_trade_no for an order. 生成商户订单号，该值在商户端应保持唯一（可自定义格式规范）
	 * 
	 */
	private String getOutTradeNo() {
		SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss",
				Locale.getDefault());
		Date date = new Date();
		String key = format.format(date);

		Random r = new Random();
		key = key + r.nextInt();
		key = key.substring(0, 15);
		return key;
	}

	/**
	 * sign the order info. 对订单信息进行签名--服务端hwudhfawefnlweqejlnfwel---sign  waonfelawliegn
	 * 
	 * @param content
	 *            待签名订单信息
	 */
	private String sign(String content) {
		return SignUtils.sign(content, RSA_PRIVATE);
	}

	/**
	 * get the sign type we use. 获取签名方式
	 * 
	 */
	private String getSignType() {
		return "sign_type=\"RSA\"";
	}

}
