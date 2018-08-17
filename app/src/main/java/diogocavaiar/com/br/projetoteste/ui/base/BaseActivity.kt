package diogocavaiar.com.br.projetoteste.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getResId())
        initAdapter()
        initUI()
        initListener()
        initPresenter()
    }

    abstract fun getResId(): Int
    abstract fun initAdapter()
    abstract fun initUI()
    abstract fun initListener()
    abstract fun initPresenter()
}