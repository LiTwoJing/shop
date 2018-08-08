package shop.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import shop.service.IpService;
@Service
public class IpServiceImpl implements IpService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private RestTemplate restTemplate;
	
	
	@Autowired
	public IpServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}



	public String ipToProvince(String ip) {
		Map<String,String> p = new HashMap<>();
		p.put("key", "991ddb41d0ba901fe35396ec2f4a0113");
		p.put("ip", ip);
		JsonNode json = restTemplate.getForObject(
				"https://restapi.amap.com/v3/ip?key={key}&ip={ip}",
				JsonNode.class, // 将响应转换成json树模型
				p);
		logger.info("调用高德地图");
		return json.at("/province").asText();
	}

}
