package app.modelo.meusclientes.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import app.modelo.meusclientes.R;
import app.modelo.meusclientes.controller.ClienteController;
import app.modelo.meusclientes.model.Cliente;


public class AdicionarClienteCardFragment extends Fragment {

    // Fragment - Classe responsável pela camada de VISÃO (Layout)
    View view;
    TextView txtTitulo;
    EditText editNomeCompleto, editTelefone, editEmail;
    EditText editCep, editLogradouro, editNumero;
    EditText editBairro, editCidade, editEstado;
    CheckBox chkTermosDeUso;
    Button btnCancelar, btnSalvar;

    Cliente novoCliente;
    ClienteController clienteController;

    public AdicionarClienteCardFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_adicionar_cliente_card, container, false);

        iniciarComponentesDeLayout();

        escutarEventosDosBotoes();

        return view;
    }

    /**
     * Inicializar os componentes da tela/layout
     * para adicionar os clientes
     */
    private void iniciarComponentesDeLayout() {
        txtTitulo = view.findViewById(R.id.txtTitulo);
        txtTitulo.setText(R.string.fragmento_adicionar_cliente_card);

        editNomeCompleto = view.findViewById(R.id.editNomeCompleto);
        editTelefone = view.findViewById(R.id.editTelefone);
        editEmail = view.findViewById(R.id.editEmail);
        editCep = view.findViewById(R.id.editCep);
        editLogradouro = view.findViewById(R.id.editLogradouro);
        editNumero = view.findViewById(R.id.editNumero);
        editBairro = view.findViewById(R.id.editBairro);
        editCidade = view.findViewById(R.id.editCidade);
        editEstado = view.findViewById(R.id.editEstado);

        chkTermosDeUso = view.findViewById(R.id.chkTermosDeUso);

        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnSalvar = view.findViewById(R.id.btnSalvar);

        novoCliente = new Cliente();
        clienteController = new ClienteController(getContext());
    }

    /**
     *
     */
    private void escutarEventosDosBotoes() {
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDadosOk = true;

                if (TextUtils.isEmpty(editNomeCompleto.getText())) {
                    isDadosOk = false;
                    Log.e("log_add_cliente", "onClick: Dados incorretos.");
                    editNomeCompleto.setError("Digite o nome completo...");
                    editNomeCompleto.requestFocus();
                }
                if (TextUtils.isEmpty(editTelefone.getText())) {
                    isDadosOk = false;
                    Log.e("log_add_cliente", "onClick: Dados incorretos.");
                    editTelefone.setError("Digite o Telefone...");
                    editTelefone.requestFocus();
                }
                if (TextUtils.isEmpty(editEmail.getText())) {
                    isDadosOk = false;
                    Log.e("log_add_cliente", "onClick: Dados incorretos.");
                    editEmail.setError("Digite o email...");
                    editEmail.requestFocus();
                }
                if (TextUtils.isEmpty(editCep.getText())) {
                    isDadosOk = false;
                    Log.e("log_add_cliente", "onClick: Dados incorretos.");
                    editCep.setError("Digite o CEP...");
                    editCep.requestFocus();
                }
                if (TextUtils.isEmpty(editLogradouro.getText())) {
                    isDadosOk = false;
                    Log.e("log_add_cliente", "onClick: Dados incorretos.");
                    editLogradouro.setError("Digite o logradouro...");
                    editLogradouro.requestFocus();
                }
                if (TextUtils.isEmpty(editNumero.getText())) {
                    isDadosOk = false;
                    Log.e("log_add_cliente", "onClick: Dados incorretos.");
                    editNumero.setError("Digite o Numero...");
                    editNumero.requestFocus();
                }
                if (TextUtils.isEmpty(editBairro.getText())) {
                    isDadosOk = false;
                    Log.e("log_add_cliente", "onClick: Dados incorretos.");
                    editBairro.setError("Digite o Bairro...");
                    editBairro.requestFocus();
                }
                if (TextUtils.isEmpty(editCidade.getText())) {
                    isDadosOk = false;
                    Log.e("log_add_cliente", "onClick: Dados incorretos.");
                    editCidade.setError("Digite a Cidade...");
                    editCidade.requestFocus();
                }
                if (TextUtils.isEmpty(editEstado.getText())) {
                    isDadosOk = false;
                    Log.e("log_add_cliente", "onClick: Dados incorretos.");
                    editEstado.setError("Digite o Estado...");
                    editEstado.requestFocus();
                }

                if (isDadosOk) {
                    Log.i("log_add_cliente", "onClick: Dados corretos.");
                    novoCliente.setNome(editNomeCompleto.getText().toString());
                    novoCliente.setTelefone(editTelefone.getText().toString());
                    novoCliente.setEmail(editEmail.getText().toString());

                    // Cast
                    novoCliente.setCep(Integer.parseInt(editCep.getText().toString()));
                    novoCliente.setLogradouro(editLogradouro.getText().toString());
                    novoCliente.setNumero(editNumero.getText().toString());
                    novoCliente.setBairro(editBairro.getText().toString());
                    novoCliente.setCidade(editCidade.getText().toString());
                    novoCliente.setEstado(editEstado.getText().toString());
                    novoCliente.setTermosDeUso(chkTermosDeUso.isChecked());

                    clienteController.incluir(novoCliente);
                }
                {
                    Log.e("log_add_cliente", "onClick: Dados incorretos.");

                }

            }
        });
    }
}
