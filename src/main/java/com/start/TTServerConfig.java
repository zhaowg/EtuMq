package tt.start;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class TTServerConfig {
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
		Resource[] resources = new ClassPathResource[] { new ClassPathResource(
				"server_params.properties") };
		pspc.setLocations(resources);
		pspc.setIgnoreUnresolvablePlaceholders(true);
		return pspc;
	}

	private @Value("${server.startport}")
	int startport;
	private @Value("${server.stopport}")
	int stopport;
	private @Value("${server.stopkey}")
	String stopkey;
	private @Value("${server.warPath}")
	String warPath;
	private @Value("${server.maxThreads}")
	int maxThreads;
	private @Value("${server.isGzip}")
	boolean isGzip;

	private @Value("${amqp.rabbit.host}")
	String mqHost = "127.0.0.1";
	private @Value("${amqp.rabbit.port}")
	int mqPort = 5672;
	private @Value("${amqp.rabbit.vhost}")
	String vhost = "/tt";
	private @Value("${amqp.rabbit.user}")
	String user = "hisun";
	private @Value("${amqp.rabbit.pass}")
	String pass = "12345";
	private @Value("${mq.exchange}")
	String exchange = "event.notice";
	private @Value("${mq.noti.webexchange}")
	String webExchange = "notice.exchange";
	private @Value("${mq.routing}")
	String routingKey = "event.notice";
	private @Value("${mq.noti.prefix}")
	String notiPre = "noti_";

	@Bean
	public TTServerStart serverStart() {
		TTServerStart start = new TTServerStart();
		start.setStopPort(stopport);
		start.setStopKey(stopkey);
		start.setStartPort(startport);
		start.setWarPath(warPath);
		start.setGzip(isGzip);
		start.setMaxThreads(maxThreads);
		
		return start;
	}

	@Bean
	public MqParams initMqParams() {
		MqParams param = new MqParams();
		param.setHost(mqHost);
		param.setPort(mqPort);
		param.setVhost(vhost);
		param.setUser(user);
		param.setPass(pass);
		param.setExchange(exchange);
		param.setRoutingKey(routingKey);
		param.setPrefix(notiPre);
		param.setWebExchange(webExchange);
		return param;
	}

	public static class MqParams {
		private String host;// rabbitmq host
		private int port;// rabbitmq port
		private String vhost = "";
		private String user = "";
		private String pass = "";
		private String exchange = "";
		private String routingKey = "";
		private String prefix = "noti_";
		private String webExchange = "";

		public String getVhost() {
			return vhost;
		}

		public void setVhost(String vhost) {
			this.vhost = vhost;
		}

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}

		public String getHost() {
			return host;
		}

		public void setHost(String host) {
			this.host = host;
		}

		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}

		public String getExchange() {
			return exchange;
		}

		public void setExchange(String exchange) {
			this.exchange = exchange;
		}

		public String getRoutingKey() {
			return routingKey;
		}

		public void setRoutingKey(String routingKey) {
			this.routingKey = routingKey;
		}

		public String getPrefix() {
			return prefix;
		}

		public void setPrefix(String prefix) {
			this.prefix = prefix;
		}

		public String getWebExchange() {
			return webExchange;
		}

		public void setWebExchange(String webExchange) {
			this.webExchange = webExchange;
		}

	}
}