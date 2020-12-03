package campuscheckin.campuscheckinapi;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/log")
public class LogController {
	private LogRepository logRepo;
	
	LogController(LogRepository lR){
		this.logRepo = lR;
	}
	
	@GetMapping("/all")
	public List<Log> getAll(){
		
		List<Log> logs = this.logRepo.findAll();
		
		return logs;
	}
	
	@GetMapping("/{action}")
	public List<Log> getLogsByAction(@PathVariable("action") String action){
		
		List<Log> logs = this.logRepo.findByActionEquals(action);
		
		return logs;
	}
	
	@PostMapping("/graph")
	public ChartOptions getGraphData(@RequestBody String action) {
		
		List<Log> logs = this.logRepo.findByActionEquals(action);
		//String[] actions = new String[logs.size()];
		String[] list = new String[logs.size()];
		Long[] data = new Long[logs.size()];
		
		for(int i=0; i<logs.size(); i++) {
			list[i] = logs.get(i).getCurrentTime();
			data[i] = logs.get(i).getTimeTaken();
			//actions[i] = logs.get(i).getAction();
		}
		
		return new ChartOptions(list,data,action);
 		
	}
	
	@GetMapping("/average")
	public DataPoint getAverageTime() {
		int test;
		String[] labels = {
				"/user/all",
				"/user/new",
		        "/user/{id}",
		        "/user/name/{name}",
		         "/user/login",
		         "/booking/all",
		         "/booking/new",
		         "/booking/{id}",
		         "/booking/findBookings/{id}",
		         "/booking/roombooking/{id}",
		         "/building/all",
		         "/building/new",
		         "/building/{id}",
		         "/room/all",
		         "/room/new",
		         "/room/{id}"
		};
		
		int[] result = new int[labels.length];
		List<Log> logs = this.logRepo.findAll();
		int sum =0;
		int count =0;
		for(int i=0;i<labels.length;i++) {
			for(int j = 0; j< logs.size(); j++) {
				if(logs.get(j).getAction().equals(labels[i])) {
					sum = sum +  Math.toIntExact(logs.get(j).getTimeTaken()); 
					count = count + 1;
					
					
				}
			}
			if(count == 0) {
				result[i] = 0;
			} else {
				int average = sum/count;
				result[i] = average;
				average = 0;
			}
			
			sum = 0;
			count = 0;
			
		}
		
		return new DataPoint(labels, result);
	}
	
	
	
	
}
