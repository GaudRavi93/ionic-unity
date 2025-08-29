package io.ionic.starter;

import android.content.Intent;
import com.getcapacitor.Plugin;
import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "Unity")
public class UnityPlugin extends Plugin {

  @PluginMethod()
  public void echo(PluginCall call) {
    String value = call.getString("value");

    JSObject ret = new JSObject();
    ret.put("value", value);
    call.resolve(ret);
  }

  @PluginMethod()
  public void launch(PluginCall call) {
    try {
      Intent intent = new Intent(getContext(), com.unity3d.player.UnityPlayerGameActivity.class);
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      getActivity().startActivity(intent);
      call.resolve();
    } catch (Exception e) {
      call.reject("Failed to launch Unity activity: " + e.getMessage());
    }
  }
}
