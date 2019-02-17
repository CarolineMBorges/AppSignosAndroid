package signos.cursoandroid.com.signos;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView listaSignos;
    private String[] signos = {"Áries", "Touro", "Gêmeos", "Câncer", "Leão", "Virgem", "Libra",
            "Escorpião", "Sagitário", "Capricórnio", "Aquário", "Peixes"};

    private String[] perfis = {"Gosta de cerveja", "Gosta de refrigerante", "Gosta de energético", "Gosta de suco",
            "Gosta de vinho", "Gosta de água", "Gosta de destilado", "Gosta de vitamina", "Gosta de leite",
            "Gosta de whisky", "Gosta de batidas", "Não gosta de nada"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);

        listaSignos = (ListView) findViewById(R.id.listViewId);

        /*
        * O Adapter é uma interface do Android
        * ArrayAdapter<> Preenche uma ArrayList com o que retornar do arrayAdapter criado
        * Depois são passados os dados
        */

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1, //layout de list disponível na própria API do Android
                android.R.id.text1,
                signos                               //array de strings com os signos
        );

        //Para tudo funcionar, o Adapter é atribuído ao ListView através do método setAdapter()
        listaSignos.setAdapter( adaptador );

        listaSignos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int codigoPosicao = position;
                //exibe a mensagem da lista perfis que estiver na mesma posicao da lista de signos
                Toast.makeText(getApplicationContext(), perfis[codigoPosicao] , Toast.LENGTH_LONG).show();

            }
        });

    }

}
