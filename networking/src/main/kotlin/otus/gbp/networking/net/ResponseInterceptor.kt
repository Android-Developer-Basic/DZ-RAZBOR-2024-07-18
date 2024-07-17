package otus.gbp.networking.net

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import java.io.BufferedReader

class ResponseInterceptor(private val readBody: Boolean = false) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response: Response = chain.proceed(chain.request())

        log { "Status message: ${response.message}" }
        log { "Total response headers: ${response.headers.size}" }
        log { "Body type: ${response::class.simpleName}" }

        if (readBody) {
            val bodyString: String? = response.body?.source()?.inputStream()?.bufferedReader()?.use {
                it.readText()
            }

            log { "Body: $bodyString" }
        }

        return response
    }

    companion object {
        private fun log(block: () -> String) {
            Log.i("Response", block())
        }
    }
}