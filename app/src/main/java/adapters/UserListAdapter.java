package adapters;

import android.content.*;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.bhsoftworks.clientspringapp.R;
import java.util.*;
import entities.User;

/**
 * Created by leandrodlm on 08/08/17.
 */

public class UserListAdapter extends ArrayAdapter<User> {

    private Context context;
    private List<User> users;

    public UserListAdapter(Context context, List<User> users) {

        super(context, R.layout.user_list_layout, users);
        this.context = context;
        this.users = users;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.user_list_layout, parent, false);
        User user = users.get(position);

        TextView textViewCodigo = (TextView) view.findViewById(R.id.textViewCodigo);
        textViewCodigo.setText(user.getCodigo());

        TextView textViewNome = (TextView) view.findViewById(R.id.textViewNome);
        textViewNome.setText(user.getNome());

        TextView textViewLogin = (TextView) view.findViewById(R.id.textViewLogin);
        textViewLogin.setText(user.getLogin());

        TextView textViewPerfil = (TextView) view.findViewById(R.id.textViewPerfil);
        textViewPerfil.setText(user.getPerfil());

        TextView textViewSenha = (TextView) view.findViewById(R.id.textViewSenha);
        textViewSenha.setText(user.getSenha());

        return view;
    }
}
