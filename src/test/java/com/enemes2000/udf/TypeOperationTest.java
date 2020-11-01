package com.enemes2000.udf;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TypeOperationTest {

    TypeOperation typeOperation;

    @Before
    public void setUp(){
      typeOperation = new TypeOperation();
    }

    @Test
    public void getTypeOperation_when_TYP_OPRN_DRD_HF13_is_null(){
        final String TYP_OPRN_DRD_HF13 = null;
        final String COD_KJCO_TRX_HF13 = "Test";
        assertEquals(typeOperation.getTypeOperation(TYP_OPRN_DRD_HF13, COD_KJCO_TRX_HF13), "TesC");
    }

    @Test
    public void getTypeOperation_when_TYP_OPRN_DRD_HF13_and_COD_KJCO_TRX_HF13_are_null(){
        final String TYP_OPRN_DRD_HF13 = null;
        final String COD_KJCO_TRX_HF13 = null;
        assertEquals(typeOperation.getTypeOperation(TYP_OPRN_DRD_HF13, COD_KJCO_TRX_HF13), null);
    }

    @Test
    public void getTypeOperation_when_COD_KJCO_TRX_HF13_is_null(){
        final String TYP_OPRN_DRD_HF13 = "Test";
        final String COD_KJCO_TRX_HF13 = null;
        assertEquals(typeOperation.getTypeOperation(TYP_OPRN_DRD_HF13, COD_KJCO_TRX_HF13), "TTest");
    }

    @Test
    public void getTypeOperation_when_TYP_OPRN_DRD_HF13_is_not_alpha(){
        final String TYP_OPRN_DRD_HF13 = " ";
        final String COD_KJCO_TRX_HF13 = null;
        assertEquals(typeOperation.getTypeOperation(TYP_OPRN_DRD_HF13, COD_KJCO_TRX_HF13), null);
    }

    @Test
    public void getTypeOperation_when_TYP_OPRN_DRD_HF13_is_alpha_and_COD_KJCO_TRX_HF13_is_alpha(){
        final String TYP_OPRN_DRD_HF13 = "Test";
        final String COD_KJCO_TRX_HF13 = "Hello";
        assertEquals(typeOperation.getTypeOperation(TYP_OPRN_DRD_HF13, COD_KJCO_TRX_HF13), "TTest");
    }


}
