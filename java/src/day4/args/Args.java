//package day4.args;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//
//public class Args {
//    public static final String SCHEMA_SEPARATOR = ",";
//    public static final String ARGUMENTS_SEPARATOR = " ";
//    public static final String ARG_PREFIX = "-";
//    HashMap<String,LinkedList<String>> schemaMap = new HashMap<>();
//    List<String> argumentsList = new LinkedList<>();
//    HashMap<String, String> argumentsMap = new HashMap<>();
//    public Args(String schema, String arguments) throws Exception {
//        if (schema == "" && arguments != ""){
//            throw new ArgNotInSchemaException(arguments);
//        }
//
//        parserSchema(schema);
//        parserArguments(arguments);
//
//    }
//
//    private boolean parserArguments(String arguments) {
//        String[] arguSeperated = arguments.split(ARGUMENTS_SEPARATOR);
//
//        for (int i = 0; i < arguSeperated.length; i++) {
//            if (arguSeperated[i].startsWith("-")) {
//                if (i + 1 < arguSeperated.length && !arguments.startsWith("-")) {
//                    argumentsMap.put(arg[i], argumentsMap[i + 1]);
//                }
//            }
//        }
//
//        return argumentsList.addAll(Arrays.asList(arguments.split(ARGUMENTS_SEPARATOR)));
//    }
//
//    private void parserSchema(String schema) {
//
//        String[] schemaArr = schema.split(SCHEMA_SEPARATOR);
//        for (String element : schemaArr) {
//            if (element.length() > 0){
//                char arg = element.charAt(0);
//                String argType = element.substring(1);
//                if (argType.length() == 0) {
//                    if (schemaMap.containsKey("bool")){
//                        schemaMap.get("bool").add(String.valueOf(arg));
//                    }else {
//                        LinkedList<String> list = new LinkedList<>();
//                        list.add(String.valueOf(arg));
//                        schemaMap.put("bool", list);
//                    }
//
//                }else if(argType == "*") {
//                    if (schemaMap.containsKey("String")){
//                        schemaMap.get("String").add(String.valueOf(arg));
//                    }else {
//                        LinkedList<String> list = new LinkedList<>();
//                        list.add(String.valueOf(arg));
//                        schemaMap.put("String", list);
//                    }
//                }
//
//            }
//        }
////        schemaList.addAll(Arrays.asList(schemaArr));
//    }
//
//    public boolean getBool(char c) throws ArgNotInSchemaException {
//
//        if (schemaMap.get("bool").contains(String.valueOf(c))) {
//            if (argumentsList.contains(ARG_PREFIX + c)) {
//                return true;
//            }
//            return false;
//        } else {
//            throw new ArgNotInSchemaException(String.valueOf(c));
//        }
//    }
//
//    public String getString(char c) {
////        if (schemaMap.get("String").contains(String.valueOf(c))){
////            if (argumentsList.contains(ARG_PREFIX + c)){
////                return
////            }
////        }
//        return "";
//    }
//}
