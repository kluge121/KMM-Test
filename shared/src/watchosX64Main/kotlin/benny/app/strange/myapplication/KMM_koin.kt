package benny.app.strange.myapplication

import benny.app.strange.myapplication.di.getDependency
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.Koin
import platform.Security.SSLContextRef

fun <T> Koin.getDependency(objCClass: ObjCClass): T? = getOriginalKotlinClass(objCClass)?.let {
    getDependency(it)
}