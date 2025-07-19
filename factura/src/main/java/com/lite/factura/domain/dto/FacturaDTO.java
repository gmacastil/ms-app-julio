package com.lite.factura.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.logstash.logback.argument.StructuredArgument;

import static net.logstash.logback.argument.StructuredArguments.entries;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacturaDTO {
    private Long id;
    
    @NotEmpty(message = "El número de factura no puede estar vacío")
    private String numero;
    
    @NotNull(message = "La fecha de emisión es obligatoria")
    private LocalDate fechaEmision;
    
    @NotNull(message = "El total es obligatorio")
    @Positive(message = "El total debe ser un valor positivo")
    private BigDecimal total;
    
    @NotNull(message = "El ID del cliente es obligatorio")
    private Long clienteId;
    
    private String descripcion;


    public StructuredArgument getValues() {
		HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("numero", numero);
        map.put("fechaEmision", fechaEmision);
        map.put("total", total);
        map.put("clienteId", clienteId);
        map.put("descripcion", descripcion);
		return entries(map);
   }
}
