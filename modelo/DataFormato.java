package biblioteca.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataFormato {
	private LocalDateTime dataAtual;

	public LocalDateTime getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(LocalDateTime dataAtual) {
		this.dataAtual = dataAtual;
	}
	
	public String getDataFormatada(LocalDateTime data) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		return data.format(formato);
	}

}