package release.ecosocial.com.ecosocial.config;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import release.ecosocial.com.ecosocial.R;

/**
 * Classe adaptador Customizada
 */
public class AdapterListView extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<ItemListView> itens;
    private Context context;


    public AdapterListView( Context context, List<ItemListView> itens ) {
        //Itens do listview
        this.itens = itens;
        //Objeto responsável por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
        this.context =  context;


    }
    @Override
    public int getCount() {
        return itens.size();
    }
    public ItemListView getItem(int position) {
        return itens.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ItemSuporte itemHolder;
        //se a view estiver nula (nunca criada), inflamos o layout nela.
        if (view == null) {
            //infla o layout para podermos pegar as views
            //view = mInflater.inflate(R.layout.item_list, null);
            LayoutInflater mInflater = (LayoutInflater)
            context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.item_list, null);


            //cria um item de suporte para não precisarmos sempre
            //inflar as mesmas informacoes
            itemHolder = new ItemSuporte();
            itemHolder.txtDescricao = ((TextView) view.findViewById(R.id.text));
            itemHolder.txtLocalidade = view.findViewById(R.id.text_localidade);
            itemHolder.imgIcon = ((ImageView) view.findViewById(R.id.imagemview));

            //define os itens na view;
            view.setTag(itemHolder);
        } else {
            //se a view já existe pega os itens.
            itemHolder = (ItemSuporte) view.getTag();
        }

        //pega os dados da lista
        //e define os valores nos itens.
        ItemListView item = itens.get(position);
        itemHolder.txtDescricao.setText(item.getTextoDescricao());
        itemHolder.txtLocalidade.setText(item.getTextoLocalidade());
        itemHolder.imgIcon.setImageResource(item.getIconeRid());

        //retorna a view com as informações
        return view;
    }

    /**
     * Classe de suporte para os itens do layout.
     */
    private class ItemSuporte {
        ImageView imgIcon;
        TextView txtLocalidade;
        TextView txtDescricao;
    }
}
