package com.enemes2000.udf;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TypeVirementTest {

    TypeVirement typeVirement;

    @Before
    public void setUp(){
        typeVirement = new TypeVirement();
    }

    @Test
    public void extractTypeVirement_when_DSC_ORIG_TRX_HF13_is_not_null(){
        final String DSC_ORIG_TRX_HF13 = "Test";
        assertEquals(typeVirement.extractTypeDeVirement(DSC_ORIG_TRX_HF13), "e");
    }

    @Test
    public void extractTypeVirement_when_DSC_ORIG_TRX_HF13_is_null(){
        final String DSC_ORIG_TRX_HF13 = null;
        assertEquals(typeVirement.extractTypeDeVirement(DSC_ORIG_TRX_HF13), null);
    }
}
