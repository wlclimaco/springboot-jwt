package com.nouhoun.springboot.jwt.integration.controller;

import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;

import com.nouhoun.springboot.jwt.integration.domain.Jogo.Dias;
import com.nouhoun.springboot.jwt.integration.repository.UserJogoDataRepository;
import com.nouhoun.springboot.jwt.integration.service.JogoService;
import com.nouhoun.springboot.jwt.integration.service.JogoUserService;
import com.nouhoun.springboot.jwt.integration.service.NotificacoesService;
import com.nouhoun.springboot.jwt.integration.service.QuadraService;
import com.nouhoun.springboot.jwt.integration.service.UserService;

public class FunctionsUtius {
	@Autowired
	public JogoService jogoService;
	@Autowired
	public QuadraService quadraService;
	@Autowired
	public UserService userService;
	@Autowired
	public NotificacoesService notificacoesService;
	@Autowired
	public JogoUserService jogoUserService;
	
	public FunctionsUtius() {
	}
	
	public GregorianCalendar shouldDownloadFile2(Dias dia,GregorianCalendar gc,String hInc)
	{
		Integer a= 0;
		if (gc.get(GregorianCalendar.DAY_OF_WEEK) == gc.SUNDAY) {
			switch (dia) { 
			case DOMINGO:
					a = 0;
				break;
			case SEGUNDA:
				a = 1;
				break;
			case TERCA:
				a = 2;
				break;
			case QUARTA:
				a = 3;
				break;
			case QUINTA:
				a = 4;
				break;
			case SEXTA:
				a = 5;
				break;
			case SABADO:
				a = 6;
				break;
			}
		}else
		if (gc.get(GregorianCalendar.DAY_OF_WEEK) == gc.MONDAY) {
			switch (dia) { 
			case DOMINGO:
					a = 6;
				break;
			case SEGUNDA:
				a = 0;
				break;
			case TERCA:
				a = 1;
				break;
			case QUARTA:
				a = 2;
				break;
			case QUINTA:
				a = 3;
				break;
			case SEXTA:
				a = 4;
				break;
			case SABADO:
				a = 5;
				break;
			}
		}else
		if (gc.get(GregorianCalendar.DAY_OF_WEEK) == gc.TUESDAY) {
			switch (dia) { 
			case DOMINGO:
					a = 5;
				break;
			case SEGUNDA:
				a = 6;
				break;
			case TERCA:
				a = 0;
				break;
			case QUARTA:
				a = 1;
				break;
			case QUINTA:
				a = 2;
				break;
			case SEXTA:
				a = 3;
				break;
			case SABADO:
				a = 4;
				break;
			}
		}else

		if (gc.get(GregorianCalendar.DAY_OF_WEEK) == gc.WEDNESDAY) {
			switch (dia) { 
			case DOMINGO:
					a = 4;
				break;
			case SEGUNDA:
				a = 5;
				break;
			case TERCA:
				a = 6;
				break;
			case QUARTA:
				a = 0;
				break;
			case QUINTA:
				a = 1;
				break;
			case SEXTA:
				a = 2;
				break;
			case SABADO:
				a = 3;
				break;
			}
		}else
		if (gc.get(GregorianCalendar.DAY_OF_WEEK) == gc.THURSDAY) {
			switch (dia) { 
			case DOMINGO:
					a = 3;
				break;
			case SEGUNDA:
				a = 4;
				break;
			case TERCA:
				a = 5;
				break;
			case QUARTA:
				a = 6;
				break;
			case QUINTA:
				a = 0;
				break;
			case SEXTA:
				a = 1;
				break;
			case SABADO:
				a = 2;
				break;
			}
		}else
		if (gc.get(GregorianCalendar.DAY_OF_WEEK) == gc.FRIDAY) {
			switch (dia) { 
			case DOMINGO:
					a = 2;
				break;
			case SEGUNDA:
				a = 3;
				break;
			case TERCA:
				a = 4;
				break;
			case QUARTA:
				a = 5;
				break;
			case QUINTA:
				a = 6;
				break;
			case SEXTA:
				a = 1;
				break;
			case SABADO:
				a = 2;
				break;
			}
		}else
		if (gc.get(GregorianCalendar.DAY_OF_WEEK) == gc.SATURDAY) {
			switch (dia) { 
			case DOMINGO:
					a = 1;
				break;
			case SEGUNDA:
				a = 2;
				break;
			case TERCA:
				a = 3;
				break;
			case QUARTA:
				a = 4;
				break;
			case QUINTA:
				a = 5;
				break;
			case SEXTA:
				a = 6;
				break;
			case SABADO:
				a = 7;
				break;
			}
		}
		
		gc.add(gc.DATE, a);
		String[] rabbitmqUserInfo = hInc.split(":");
		gc.set(GregorianCalendar.HOUR_OF_DAY,Integer.parseInt(rabbitmqUserInfo[0]));
		gc.set(GregorianCalendar.MINUTE,Integer.parseInt(rabbitmqUserInfo[1]));
		
		//gc.add(gc.HOUR, Integer.parseInt(rabbitmqUserInfo[0]));
	//	gc.add(gc.MINUTE, Integer.parseInt(rabbitmqUserInfo[0]));
		return gc;
	}
}