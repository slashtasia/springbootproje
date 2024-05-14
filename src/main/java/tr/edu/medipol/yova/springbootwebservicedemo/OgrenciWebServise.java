package tr.edu.medipol.yova.springbootwebservicedemo;
import java.util.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ogrenci")
public class OgrenciWebServise {
	
	public record Ogrenci (String numara, String name) {}
	
	private static List<Ogrenci> OGRENCILER = new ArrayList<>();
	static {
		OGRENCILER.add(new Ogrenci("1", "Ali"));
		OGRENCILER.add(new Ogrenci("2", "Ayse"));
	}
	
	@GetMapping("/")
	public List<String> listele() {
		return new ArrayList<>();
	}
	
	@PostMapping("/")
	public void ekle(Ogrenci yeniOgrenci) {
		OGRENCILER.add(yeniOgrenci);
	}
	@DeleteMapping("/{numara}")
	public boolean sil (@PathVariable("numara") String numara) {
		for(Ogrenci ogrenci: OGRENCILER) {
			if(ogrenci.numara.equals(numara)) {
				OGRENCILER.remove(ogrenci);
				return true;
			}
		}
		
		//OGRENCI BULUNAMADI
	return false;
	}

}
