package com.rolandopalermo.facturacion.ec.mapper.bol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.rolandopalermo.facturacion.ec.dto.v1_0.bol.DestinatarioDTO;
import com.rolandopalermo.facturacion.ec.dto.v1_0.bol.GuiaDetallesDTO;
import com.rolandopalermo.facturacion.ec.mapper.Mapper;
import com.rolandopalermo.facturacion.ec.modelo.guia.Destinatario;
import com.rolandopalermo.facturacion.ec.modelo.guia.GuiaDetalles;

@Component("destinatarioMapper")
public class DestinatarioMapper implements Mapper<DestinatarioDTO, Destinatario> {

	private Mapper<GuiaDetallesDTO, GuiaDetalles> guiaDetalleMapper;

	@Override
	public Destinatario convert(final DestinatarioDTO destinatarioDTO) {
		if (destinatarioDTO == null) {
			return null;
		}
		final Destinatario des = new Destinatario();
		des.setIdentificacionDestinatario(destinatarioDTO.getIdentificacionDestinatario());
		des.setRazonSocialDestinatario(destinatarioDTO.getRazonSocialDestinatario());
		des.setDirDestinatario(destinatarioDTO.getDirDestinatario());
		des.setMotivoTraslado(destinatarioDTO.getMotivoTraslado());
		des.setDocAduaneroUnico(destinatarioDTO.getDocAduaneroUnico());
		des.setCodEstabDestino(destinatarioDTO.getCodEstabDestino());
		des.setRuta(destinatarioDTO.getRuta());
		des.setCodDocSustento(destinatarioDTO.getCodDocSustento());
		des.setNumDocSustento(destinatarioDTO.getNumDocSustento());
		des.setNumAutDocSustento(destinatarioDTO.getNumAutDocSustento());
		des.setFechaEmisionDocSustento(destinatarioDTO.getFechaEmisionDocSustento());
		des.setDetalle(getGuiaDetalleMapper().convertAll(destinatarioDTO.getDetalle()));

		return des;
	}

	protected Mapper<GuiaDetallesDTO, GuiaDetalles> getGuiaDetalleMapper() {
		return guiaDetalleMapper;
	}

	@Autowired
	@Qualifier("guiaDetalleMapper")
	public void setGuiaDetalleMapper(Mapper<GuiaDetallesDTO, GuiaDetalles> guiaDetalleMapper) {
		this.guiaDetalleMapper = guiaDetalleMapper;
	}
	
}