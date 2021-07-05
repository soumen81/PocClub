package com.autumntechcreation.pocclub.util

object AppConstants {
    /**
     * Connection timeout duration
     */
    val CONNECT_TIMEOUT = 60
    /**
     * Connection Read timeout duration
     */
    val READ_TIMEOUT = 60
    /**
     * Connection write timeout duration
     */
    val WRITE_TIMEOUT = 60
    /**
     * Connection write timeout duration
     */
    val CONECTION_FAILED_TIMEOUT_MESSAGE = "failed to connect"
    val TIMEOUT_MESSAGE = "timeout"


    /**
     * Endpoint
     */
    // public static final String BASE_URL = "http://192.168.100.68/";
    const val BASE_URL = "http://182.75.123.94"


    val AZURE_BASE_URL_QUALITY = "https://fvconstruction.azurewebsites.net"
    val AZURE_BASE_URL_FRAMEWORK = "https://fvframework.azurewebsites.net"
    val AZURE_BASE_URL_FINANCE = "https://fvfinance.azurewebsites.net"
    val AZURE_BASE_URL_MATERIAL = "https://fvmaterial.azurewebsites.net"
    val AZURE_BASE_URL_PAYROLL = "https://fvpayroll.azurewebsites.net"
    val AZURE_BASE_URL_HR = "https://fvhr.azurewebsites.net"
    val AZURE_BASE_URL_SFA = "https://fvsfa.azurewebsites.net"
    val AZURE_BASE_URL_CRM = "https://fvcrm.azurewebsites.net"
    val AZURE_BASE_URL_DATA_IMPOTER = "https://fvdataimporter.azurewebsites.net"
    val AZURE_BASE_URL_DATA_DOCUMENT_PRINT = "https://fvreports.azurewebsites.net"
    val AZURE_BASE_URL_DATA_MEDICENTER = "https://fvmediacenter.azurewebsites.net"
    val AZURE_BASE_URL_DATA_CTI = "https://fvcti.azurewebsites.net"
    val AZURE_BASE_URL_DATA_FMS = "https://fvfms.azurewebsites.net"
    val AZURE_BASE_URL_DATA_CTI_REALTIME = "https://fvcti.azurewebsites.net/signalr"
    val AZURE_BASE_URL_DATA_REPORTS_SERVER = "http://40.81.252.90/ReportServer"
    val AZURE_BASE_URL_DATA_REPORTS_URL = "https://fvreports.azurewebsites.net/SSRSReport"
    val AZURE_BASE_URL_DATA_SALES = "https://fvsales.azurewebsites.net"
    val AZURE_BASE_URL_DATA_SYNC = "http://localhost:36767"
    val AZURE_BASE_URL_DATA_CS = "https://fvcustomersupport.azurewebsites.net"
    const val AZURE_BASE_URL_CONTRUCTION = "https://fvconstruction.azurewebsites.net"
    /**
     * Database
     */
    val DATABASE = "fvBroker_database"

    /**
     * SharedPreference
     */
    val PREF_NAME = "fvBroker_pref"


    val LIST_VISIBLE_COUNT_VIEW:Long= 5000
}