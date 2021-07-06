package com.gamut.fvcustomerorder.util

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.ConnectivityManager
import android.util.Base64
import android.util.Base64OutputStream
import android.widget.Toast
import com.autumntechcreation.pocclub.R
import com.autumntechcreation.pocclub.util.AppConstants

import okhttp3.ResponseBody
import java.io.*
import java.math.BigDecimal
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

object Static {
    val VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)
    const val IPV4_REGEX =
            "(([0-1]?[0-9]{1,2}\\.)|(2[0-4][0-9]\\.)|(25[0-5]\\.)){3}(([0-1]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))"
    const val PHONE_REGEX = "^[0-9]{10}$"

    const val MID_IN :Int= 3101
    const val MID_OUT: Int = 3102
    const val POGRN: Int = 2701
    var exitTime: Long = 0
    const val GOODS_RECEIPT_NOTE_ID = 83
    const val FIXED_ASSET_PURCHASE = 79 //290

    fun getYearMonthDate(inputDate: String): Array<String> {
        return inputDate.split("-".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    }

    fun curentDateTimeServerFormate(): String {
        return SimpleDateFormat("yyyy-MM-dd'T'00:00:00", Locale.getDefault()).format(
                Date()
        )
    }

    fun curentDate(): String {
        return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

    }
    fun curentDateDDMMYYYY(): String {
        return SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())

    }

    fun curentTimestamp(): String {
        val tsLong = System.currentTimeMillis() / 1000
        val ts = tsLong.toString()
        return ts

    }

    fun dateToTimestamp(input: String): Long {
        //  String str_date=mCalender+"-"+day+"-"+yr;
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        var date: Date? = null
        try {
            date = formatter.parse(input)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val output = date!!.time / 1000L
        val str = java.lang.Long.toString(output)
        return java.lang.Long.parseLong(str) * 1000
    }

    fun convertPickDate(strDate: String): String {
        var strDate = strDate
        val formatter1 = SimpleDateFormat("dd/MM/yyyy")
        var date: Date? = null
        try {
            date = formatter1.parse(strDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val formatter2 = SimpleDateFormat("yyyy-MM-dd")
        strDate = formatter2.format(date)
        println("Date Format with MM/dd/yyyy : $strDate")
        return strDate
    }

    fun localToUTC(dateFormat: String, datesToConvert: String): String {


        var dateToReturn = datesToConvert

        val sdf = SimpleDateFormat(dateFormat)
        sdf.timeZone = TimeZone.getDefault()
        var gmt: Date? = null

        val sdfOutPutToSend = SimpleDateFormat(dateFormat)
        sdfOutPutToSend.timeZone = TimeZone.getTimeZone("UTC")

        try {

            gmt = sdf.parse(datesToConvert)
            dateToReturn = sdfOutPutToSend.format(gmt)

        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return dateToReturn
    }

    fun curentTimeServerFormate000(): String {
        return SimpleDateFormat("'T'00:00:00", Locale.getDefault()).format(Date())
    }

    fun splitDate(inputDate: String): String {
        val parts = inputDate.split("T".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        return parts[0]
    }

    fun convertYYYYMMDDTODDMMYYYY(input: String): String {
        var input = input
        try {
            //create SimpleDateFormat object with source string date format
            val sdfSource = SimpleDateFormat("yyyy-MM-dd")

            //parse the string into Date object
            val date = sdfSource.parse(input)

            //create SimpleDateFormat object with desired date format
            val sdfDestination = SimpleDateFormat("dd-MM-yyyy")

            //parse the date into another format
            input = sdfDestination.format(date)


        } catch (pe: ParseException) {
            println("Parse Exception : $pe")
        }

        return input
    }

    fun getAppVersion(context: Context): String {
        var version = ""
        try {
            val pInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            version = pInfo.versionName

        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        return version
    }


    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    fun convertBitmapToString(bitmap: Bitmap): String? {
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        return Base64.encodeToString(
                outputStream.toByteArray(),
                Base64.DEFAULT
        )
    }

    fun resize(image: Bitmap, maxWidth: Int, maxHeight: Int): Bitmap? {
        var image = image
        return if (maxHeight > 0 && maxWidth > 0) {
            val width = image.width
            val height = image.height
            val ratioBitmap = width.toFloat() / height.toFloat()
            val ratioMax = maxWidth.toFloat() / maxHeight.toFloat()
            var finalWidth = maxWidth
            var finalHeight = maxHeight
            if (ratioMax > ratioBitmap) {
                finalWidth = (maxHeight.toFloat() * ratioBitmap).toInt()
            } else {
                finalHeight = (maxWidth.toFloat() / ratioBitmap).toInt()
            }
            image = Bitmap.createScaledBitmap(image, finalWidth, finalHeight, true)
            image
        } else {
            image
        }
    }

    fun convertImageFileToBase64(imageFile: File): String {
        return FileInputStream(imageFile).use { inputStream ->
            ByteArrayOutputStream().use { outputStream ->
                Base64OutputStream(outputStream, Base64.DEFAULT).use { base64FilterStream ->
                    inputStream.copyTo(base64FilterStream)
                    base64FilterStream.close() // This line is required, see comments
                    outputStream.toString()
                }
            }
        }
    }


    fun writeResponseBodyToDisk(
            path: String,
            body: ResponseBody,
            paySlipName: String
    ): Boolean {
        var fileOutputStream: FileOutputStream? = null
        var inputStream: InputStream? = null
        val folder = File(path, "FvStore")
        folder.mkdir()
        val pdfFile = File(folder, paySlipName)
        try {
            pdfFile.createNewFile()
        } catch (var7: IOException) {
            var7.printStackTrace()
        }
        inputStream = body.byteStream()
        try {
            fileOutputStream = FileOutputStream(pdfFile)
            val totalSize = body.contentLength()
            //val buffer = ByteArray(4096)
            val buffer = ByteArray(409600)
            var bufferLength: Int
            while (inputStream.read(buffer).also { bufferLength = it } > 0) {
                fileOutputStream.write(buffer, 0, bufferLength)
            }
            fileOutputStream.close()
            return true
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        return false
    }
    fun doExitApp(activity: Activity) {
        if (System.currentTimeMillis() -exitTime > 2000) {
            Toast.makeText(activity, R.string.press_again_exit_app, Toast.LENGTH_SHORT).show()
            exitTime = System.currentTimeMillis()
        } else {
            activity.finish()
        }
    }

    fun convertNewDate(strDate: String): String? {
        var strDate = strDate
        val formatter1 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val formatter2 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'")
        var date: Date? = null
        try {
            date = formatter1.parse(strDate)
        } catch (e: ParseException) {
            try {
                date = formatter2.parse(strDate)
            } catch (e2: ParseException) {
                e2.printStackTrace()
            }
            e.printStackTrace()
        }
        val formatter3 = SimpleDateFormat("dd/MM/yyyy")
        strDate = formatter3.format(date)
        println("Date Format with MM/dd/yyyy : $strDate")
        return strDate
    }

    //new dated convert......
    fun convertToDate(strDate: String): String? {
        var strDate = strDate
        val formatter1 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val formatter2 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") //2020-08-19T18:30:00.000Z
        val formatter3 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss") //2020-08-19T18:30:00.000Z
        val formatter4 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSZ") //2020-08-19T18:30:00.0000000Z
        var date: Date? = null
        try {
            date = formatter1.parse(strDate)
        } catch (e: ParseException) {
            try {
                date = formatter2.parse(strDate)
            } catch (e2: ParseException) {
                e2.printStackTrace()
            }
            try {
                date = formatter3.parse(strDate)
            } catch (e3: ParseException) {
                e3.printStackTrace()
            }
            try {
                date = formatter4.parse(strDate)
            } catch (e4: ParseException) {
                e4.printStackTrace()
            }
            e.printStackTrace()
        }
        val formatter5 = SimpleDateFormat("dd/MM/yyyy")
        strDate = formatter5.format(date)
        println("Date Format with MM/dd/yyyy : $strDate")
        return strDate
    }
    fun splitByColon(inputDate: String): String? {
        val parts = inputDate.split(":".toRegex()).toTypedArray()
        return parts[0]
    }

    fun toPrecision(dec: BigDecimal, precision: Int): BigDecimal? {
        val plain = dec.movePointRight(precision).toPlainString()
        return BigDecimal(plain.substring(0, plain.indexOf("."))).movePointLeft(precision)
    }


    fun convertYYYTMMDDTODDMMYYYYY(strDate: String): String? {
        var strDate = strDate
        val formatter1 = SimpleDateFormat("yyyy-MM-dd")
        var date: Date? = null
        try {
            date = formatter1.parse(strDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        val formatterNew = SimpleDateFormat("dd/MM/yyyy")
        strDate = formatterNew.format(date)
        println("Date Format with MM/dd/yyyy : $strDate")
        return strDate
    }


    fun splitByT(inputDate: String): String? {
        val parts = inputDate.split("T".toRegex()).toTypedArray()
        return parts[0]
    }

    fun splitDateT(inputDate: String): String? {
        val parts = inputDate.split("T".toRegex()).toTypedArray()
        return parts[0]
    }

    fun getDynamicUrlValue(position: Int): String? {
        val map = HashMap<Int, String>()
        map[3] = "framework"
        map[4] = "finance"
        map[5] = "construction"
        map[6] = "material"
        map[7] = "payroll"
        map[8] = "property"
        map[9] = "BusinessDevelopment"
        map[10] = "HR"
        map[11] = "sfa"
        map[12] = "crm"
        map[13] = "FixedAsset"
        map[14] = "EmployeePortal"
        map[15] = "product"
        map[16] = "MediaCenter"
        map[17] = "ContactCenter"
        map[18] = "FMS"
        map[19] = "Sales"
        map[20] = "CustomerSupport"
        map[21] = "DataImporter"
        map[22] = "CTI"
        map[23] = "Production"
        map[24] = "LatePaymentFee"
        return map[position]
    }


    fun getDynamicUrlValueForAzure(position: Int): String? {
        val map = HashMap<Int, String>()
        map[3] = AppConstants.AZURE_BASE_URL_FRAMEWORK
        map[4] = AppConstants.AZURE_BASE_URL_FINANCE
        map[5] = AppConstants.AZURE_BASE_URL_CONTRUCTION
        map[6] = AppConstants.AZURE_BASE_URL_MATERIAL
        map[7] = AppConstants.AZURE_BASE_URL_PAYROLL
        map[8] = ""
        map[9] = ""
        map[10] = AppConstants.AZURE_BASE_URL_HR
        map[11] = AppConstants.AZURE_BASE_URL_SFA
        map[12] = AppConstants.AZURE_BASE_URL_CRM
        map[13] = ""
        map[14] = ""
        map[15] = ""
        map[16] = AppConstants.AZURE_BASE_URL_DATA_MEDICENTER
        map[17] = ""
        map[18] = AppConstants.AZURE_BASE_URL_DATA_FMS
        map[19] = AppConstants.AZURE_BASE_URL_DATA_SALES
        map[20] = ""
        map[21] = ""
        map[22] = ""
        map[23] = ""
        map[24] = ""
        return map[position]
    }

}