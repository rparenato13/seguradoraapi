package com.renatoalmeida.seguradoraapi.services.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.renatoalmeida.seguradoraapi.domain.Apolice;
import com.renatoalmeida.seguradoraapi.services.SequenceGeneratorService;

@Component
public class ApoliceModelListener extends AbstractMongoEventListener<Apolice> {

    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public ApoliceModelListener(SequenceGeneratorService sequenceGeneratorService) {
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Apolice> event) {
        if (event.getSource().getNumero() < 1) {
            event.getSource().setNumero(sequenceGeneratorService.generateSequence(Apolice.SEQUENCE_NAME));
        }
    }
	
}
