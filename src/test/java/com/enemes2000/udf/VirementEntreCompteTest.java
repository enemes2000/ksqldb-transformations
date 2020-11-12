package com.enemes2000.udf;

import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Struct;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VirementEntreCompteTest {

    VirementEntreCompte virementEntreCompte;
    final  static  String INPUT_STRUCT_DESCRIPTOR =  "STRUCT<" + "DSC_ORIG_TRX_HF13" + ">";

    public static final Schema INPUT_SCHEMA = SchemaBuilder.struct().optional()
            .field("DSC_ORIG_TRX_HF13", Schema.OPTIONAL_STRING_SCHEMA)
            .build();

    @Before
    public void setUp(){
        virementEntreCompte = new VirementEntreCompte();
    }

    @Test
    public void extractVirementCompte_when_DSC_ORIG_TRX_HF13_equals_1(){
        final String DSC_ORIG_TRX_HF13 = "02F1815C30190C0052923CF0F2F0F1404040404040404040404040404040";
        Struct DSC_ORIG_TRX_HF13_STRUCT = new Struct(INPUT_SCHEMA);
        DSC_ORIG_TRX_HF13_STRUCT.put("DSC_ORIG_TRX_HF13", DSC_ORIG_TRX_HF13);
        assertEquals(virementEntreCompte.extractVirementCompte(DSC_ORIG_TRX_HF13_STRUCT).get(0).get("NUM-INSN-CNTP"),"8");
        assertEquals(virementEntreCompte.extractVirementCompte(DSC_ORIG_TRX_HF13_STRUCT).get(0).get("NUM-CAIS-CNTP"),"3");
        assertEquals(virementEntreCompte.extractVirementCompte(DSC_ORIG_TRX_HF13_STRUCT).get(0).get("NUM-FOLI-CNTP"),"0");
        assertEquals(virementEntreCompte.extractVirementCompte(DSC_ORIG_TRX_HF13_STRUCT).get(0).get("NUM-SERV-CNTP"),"F");
        assertEquals(virementEntreCompte.extractVirementCompte(DSC_ORIG_TRX_HF13_STRUCT).get(0).get("NUM-CMPT-CNTP"),"F");

    }
}
