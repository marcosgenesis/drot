package br.com.pi.drot.utils;

import br.com.pi.drot.entity.TratamentoPaciente;

public interface TratamentosIterator {
	 boolean hasNext();
	 TratamentoPaciente getNext();
	 void reset();
}
