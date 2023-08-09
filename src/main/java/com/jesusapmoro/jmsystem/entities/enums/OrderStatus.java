package com.jesusapmoro.jmsystem.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	//criar um construtor do tipo enumerado ele é private
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	//para o codigo code ficar acessível a mundo exterior eu vou criar público para acessar esse código
	public int getCode() {
		return code;
	}
	
	//criar um método estático pra converter um valor numérico para um tipo numerado(static porque esse método vai funcionar sem estanciar
	//vou chamar esse método de velueOf passsando aqui um código como argumento ou seja eu vou passar um código e esse método vai
	//me retornar ordemStatus correspondente a esse código
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		//lançar um execessão do java
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
