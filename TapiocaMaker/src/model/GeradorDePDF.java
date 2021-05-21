package model;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import controller.facade.FacadeCardapio;
import model.factoryMethod.Tapioca;

public class GeradorDePDF {
    
	public void gerarDadosDoCliente(Pedido pedido,String arquivo,String data, String hora,int tempoDeEntrega){
		Rectangle p = new Rectangle(PageSize.A5);
		p.setBackgroundColor(new BaseColor(255,222,173));
		Document document = new Document(p);
		float totalAPagar = 0;
		try {
			PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			document.open();
			Image figura = null;
			try {
				figura = Image.getInstance(getClass().getResource("/Tapioca- Logan.jpg"));
			} catch (Exception e) {}
			figura.setAlignment(Element.ALIGN_CENTER);
			figura.scaleAbsolute(210, 120);
			document.add(figura);
			document.add(new Paragraph("Nome do cliente: "+pedido.getCliente().getNome().toUpperCase()));
			document.add(new Paragraph("---------------------------------------------------------------------------"));
			document.add(new Paragraph("TAPIOCAS:"));
			for(int cont = 0;cont<pedido.getCliente().getCarrinho().size();cont++){
			document.add(new Paragraph((cont+1)+" - "+pedido.getCliente().getCarrinho().get(cont).toString()));
			totalAPagar+=pedido.getCliente().getCarrinho().get(cont).getPreco();
			}
			document.add(new Paragraph("---------------------------------------------------------------------------"));
			document.add(new Paragraph("DADOS DE ENTREGA E COMPRA:"));
			document.add(new Paragraph("Total a pagar: "+totalAPagar));
			document.add(new Paragraph("Tempo de entrega: "+tempoDeEntrega+" minutos"));
			document.add(new Paragraph("---------------------------------------------------------------------------"));
			document.add(new Paragraph("INFORMAÇÕES DO PEDIDO:"));
			document.add(new Paragraph("Data do pedido: "+data));
			document.add(new Paragraph("Hora do pedido: "+hora+" hrs"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		document.close();
	}
	public void gerarDadosDeCompraParaOAdministrador(Pedido pedido,String arquivo,String data, String hora,int tempoDeEntrega){
		Rectangle p = new Rectangle(PageSize.A5);
		p.setBackgroundColor(new BaseColor(255,222,173));
		Document document = new Document(p);
		float totalAPagar = 0;
		try {
			PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			document.open();
			Image figura = null;
			try {
				figura = Image.getInstance(getClass().getResource("/Tapioca- Logan.jpg"));
			} catch (Exception e) {}
			figura.setAlignment(Element.ALIGN_CENTER);
			figura.scaleAbsolute(210, 120);
			document.add(figura);
			document.add(new Paragraph("DADOS DO(A) CLIENTE:"));
			document.add(new Paragraph("Nome do cliente: "+pedido.getCliente().getNome().toUpperCase()));
			document.add(new Paragraph("Endereço: "+pedido.getEndereco().toUpperCase()));
			document.add(new Paragraph("E-mail do cliente: "+pedido.getCliente().getEmail()));
			document.add(new Paragraph("---------------------------------------------------------------------------"));
			document.add(new Paragraph("TAPIOCAS COMPRADAS:"));
			for(int cont = 0;cont<pedido.getCliente().getCarrinho().size();cont++){
			document.add(new Paragraph((cont+1)+" - "+pedido.getCliente().getCarrinho().get(cont).toString()));
			totalAPagar+=pedido.getCliente().getCarrinho().get(cont).getPreco();
			}
			document.add(new Paragraph("---------------------------------------------------------------------------"));
			document.add(new Paragraph("DADOS DE ENTREGA E COMPRA:"));
			document.add(new Paragraph("Total a pagar: "+totalAPagar));
			document.add(new Paragraph("Tempo para ser entrege o pedido: "+tempoDeEntrega+" minutos"));
			document.add(new Paragraph("---------------------------------------------------------------------------"));
			document.add(new Paragraph("INFORMAÇÕES DO PEDIDO:"));
			document.add(new Paragraph("Data do pedido: "+data));
			document.add(new Paragraph("Hora do pedido: "+hora+" hrs"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		document.close();
	}
	public void gerarCardapio(FacadeCardapio facadeCardapio, String arquivo){
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			document.open();
			for(int cont = 0;cont<facadeCardapio.getTapiocas().size();cont++){
				String ingredientes = "";
				Tapioca t = facadeCardapio.getTapiocas().get(cont);
				for(int i = 0;i<t.getArray().size();i++){
					if(i==t.getArray().size()-1){
						ingredientes+= t.getArray().get(i).getNome();
					}else{
					    ingredientes+= t.getArray().get(i).getNome()+",";
					}
				}
				document.add(new Paragraph(t.getNome()+" ( "+ingredientes+" ).............R$ "+t.getPreco()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		document.close();
	}
	public void gerarRelatorio(FacadeCardapio facadeCardapio, String arquivo){
		Document document = new Document();
			try {
				PdfWriter.getInstance(document, new FileOutputStream(arquivo));
				document.open();
				Paragraph paragrafo = new Paragraph("TAPIOCAS MAIS COMPRADAS");
				paragrafo.setAlignment(Element.ALIGN_CENTER);
				document.add(paragrafo);
				document.add(new Paragraph("-----------------------------------------------------------"));
				float total = 0;
				for(int cont = 0;cont<facadeCardapio.getTapiocas().size();cont++){
					int quantidade = facadeCardapio.getTapiocas().get(cont).getQuantidadeDaTapiocaComprada();
					float preco = 0;
					if(quantidade>0){
					preco = quantidade*facadeCardapio.getTapiocas().get(cont).getPreco();
					total+=preco;
					}
					document.add(new Paragraph(facadeCardapio.getTapiocas().get(cont).toString()+" - quantidade: "+facadeCardapio.getTapiocas().get(cont).getQuantidadeDaTapiocaComprada()+" ----------------------------------- total arrecadado: "+preco));
			}
		       for(Tapioca ta:facadeCardapio.getTapiocasExcluidas()){
		    	   float preco = 0;
		    	   if(ta.getQuantidadeDaTapiocaComprada()>0){
		    		   preco = ta.getQuantidadeDaTapiocaComprada()*ta.getPreco();
		    		   total+=preco;
		    	   }
		    	   document.add(new Paragraph(ta.toString()+" - quantidade: "+ta.getQuantidadeDaTapiocaComprada()+" ---------------------------------- total arrecadado: "+preco));
		       }
		       document.add(new Paragraph("----------------------------------------------------------"));
		       document.add(new Paragraph("RECEITA:"));
		       document.add(new Paragraph("Total da receita: "+total));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (DocumentException e) {
				e.printStackTrace();
			}
			document.close();
	}
}
