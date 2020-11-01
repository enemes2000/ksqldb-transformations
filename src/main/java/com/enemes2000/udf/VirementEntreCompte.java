package com.enemes2000.udf;


import io.confluent.ksql.function.udf.UdfParameter;
import io.confluent.ksql.function.udtf.Udtf;
import io.confluent.ksql.function.udtf.UdtfDescription;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Struct;

@UdtfDescription(name = "VirementEntreCompte", description = "virement entre compte  - Rule 7")
public class VirementEntreCompte {


 final String OUTPUT_STRUCT_DESCRIPTOR = "STRUCT<" + "NUM-INSN-CNTP STRING," + "NUM-CAIS-CNTP STRING," + "NUM-FOLI-CNTP STRING," + "NUM-SERV-CNTP STRING" + "NUM-CMPT-CNTP" + ">";

 private static final int NUM_INSN_CNTP_IND = 4;
 private static final int NUM_CAIS_CNTP_IND = 8;
 private static final int NUM_FOLI_CNTP_IND = 14;
 private static final int NUM_SERV_CNTP_IND = 22;
 private static final int NUM_CMPT_CNTP_IND = 26;


 public static final Schema OUTPUT_SCHEMA = SchemaBuilder.struct().optional()
         .field("NUM-INSN-CNTP", Schema.OPTIONAL_STRING_SCHEMA)
         .field("NUM-CAIS-CNTP", Schema.OPTIONAL_STRING_SCHEMA)
         .field("NUM-FOLI-CNTP", Schema.OPTIONAL_STRING_SCHEMA)
         .field("NUM-SERV-CNTP", Schema.OPTIONAL_STRING_SCHEMA)
         .field("NUM-CMPT-CNTP", Schema.OPTIONAL_STRING_SCHEMA)
         .build();


 @Udtf(description = "Extract field for virement entre compte", schema = OUTPUT_STRUCT_DESCRIPTOR)
 public Struct extractVirementCompte(@UdfParameter("DSC_ORIG_TRX_HF13") final String DSC_ORIG_TRX_HF13) {

  if ("1".equals(DSC_ORIG_TRX_HF13.substring(1,2))||
          "2".equals(DSC_ORIG_TRX_HF13.substring(1,2)) ||
          "3".equals(DSC_ORIG_TRX_HF13.substring(1,2)) ||
          "4".equals(DSC_ORIG_TRX_HF13.substring(1,2))) {

          return new Struct(OUTPUT_SCHEMA)
                   .put("NUM-INSN-CNTP", getNUM_INSN_CNTP_FROM(DSC_ORIG_TRX_HF13))
                   .put("NUM-CAIS-CNTP", getNUM_CAIS_CNTP_FROM(DSC_ORIG_TRX_HF13))
                   .put("NUM-FOLI-CNTP", getNUM_FOLI_CNTP_FROM(DSC_ORIG_TRX_HF13))
                   .put("NUM-SERV-CNTP", getNUM_SERV_CNTP_FROM(DSC_ORIG_TRX_HF13))
                   .put("NUM-CMPT-CNTP", getNUM_CMPT_CNTP_FROM(DSC_ORIG_TRX_HF13));

  }

  
 return  null;

 }

 private String getNUM_INSN_CNTP_FROM(String input){
   return  String.valueOf(input.charAt(NUM_INSN_CNTP_IND));
 }

 private String getNUM_CAIS_CNTP_FROM(String input){
  return   String.valueOf(input.charAt(NUM_CAIS_CNTP_IND));
 }

 private String getNUM_FOLI_CNTP_FROM(String input){
  return   String.valueOf(input.charAt(NUM_FOLI_CNTP_IND));
 }

 private String getNUM_SERV_CNTP_FROM(String input){
  return  String.valueOf(input.charAt(NUM_SERV_CNTP_IND));
 }

 private String getNUM_CMPT_CNTP_FROM(String input){
  return   String.valueOf(input.charAt(NUM_CMPT_CNTP_IND));
 }
}
