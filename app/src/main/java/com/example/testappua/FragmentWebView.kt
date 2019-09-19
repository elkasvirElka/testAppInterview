package com.example.testappua

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment

class FragmentWebView : Fragment(){

    private lateinit var webView : WebView
    private lateinit var url : String
    companion object {

        @JvmStatic
        fun newInstance(url:String) = FragmentWebView().apply  {
            this.url = url
        }

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view =  inflater.inflate(R.layout.fragment_web_view, container, false)
        webView = view.findViewById(R.id.webView1)
        webView.getSettings().setJavaScriptEnabled(true)
        webView.loadUrl(url)
        return view
    }
}