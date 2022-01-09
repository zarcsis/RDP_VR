package com.mefazm.rdpvr

class Log {
    companion object {
        fun i(msg: String) {
            val stackElement = Thread.currentThread().stackTrace[3]
            val fullClassName = stackElement.className
            val className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1)
            android.util.Log.i(className,"${stackElement.methodName}(${stackElement.lineNumber}): " + msg)
        }
    }
}
