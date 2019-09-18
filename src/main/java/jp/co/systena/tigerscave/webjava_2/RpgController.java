package jp.co.systena.tigerscave.webjava_2;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RpgController {

  @Autowired
  HttpSession session;                  // セッション管理

//URLとのマッピング(キャラ作成)
   @RequestMapping(value="/JobSelection", method=RequestMethod.GET)
   public ModelAndView JobSelection(ModelAndView mav) {

     // 名前情報を格納するインスタンス生成
     // 毎回初期化する
     session.removeAttribute("name");

     // 職業情報を格納するインスタンス生成
     // 毎回初期化する
     session.removeAttribute("job");

     // Viewのテンプレート名を設定
     mav.setViewName("JobSelection");
     return mav;
   }

 //URLとのマッピング(行動選択)
	@RequestMapping(value="/ActionSelection", method=RequestMethod.GET)
	public ModelAndView RegisterChara(@RequestParam(value="name") String name,@RequestParam(value="job") String job,ModelAndView mav) {
		mav.setViewName("ActionSelection");
		return mav;
	}

   /*@RequestMapping(value="/ResultView", method=RequestMethod.POST)
   public ModelAndView order(ModelAndView mav, @Valid ListForm listForm, BindingResult bindingResult, HttpServletRequest request) {

     // セッション情報から保存したデータを取得する。
     Cart cart = (Cart) session.getAttribute("cart");
     if (cart == null) {
       // 初期だった場合作成
       cart = new Cart();
       session.setAttribute("cart", cart);
     }

     if (bindingResult.getAllErrors().size() > 0) {
       // エラーがある場合はそのまま戻す
       mav.addObject("listForm",listForm);  // 新規クラスを設定
       mav.addObject("cart", cart);

       // Viewのテンプレート名を設定
       mav.setViewName("ListView");
       return mav;
     }

     // itemIdから商品名と価格を取得(Mapを使用)
     HashMap<Integer, Item> ItemList = new HashMap<Integer, Item>();
     ListService service = new ListService();
     List<Item> itemList = service.getItemList();
     for (Item item : itemList) {
       ItemList.put(item.getItemid(), item);
     }
     mav.addObject("itemList", ItemList);

     // セッションに保存する
     Order order = new Order();
     order.setItemid(listForm.itemId);
     order.setNum(listForm.count);
     cart.add(order);
     session.setAttribute("cart", cart);

     mav.addObject("orderList", cart.getOrderList());

     mav.setViewName("ResultView");
     return mav;
   }
   */
}
