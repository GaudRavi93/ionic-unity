# Ionic + Unity Integration Guide

### 1. Create Ionic Angular Application
```bash
ionic start
```

### 2. Add Android Platform in Ionic Application
```bash
npm install @capacitor/android
npx cap add android
```

### 3. Add Unity Project
Place the Unity project inside a folder named `unity`.

### 4. Create Bridge for Unity → Ionic → Android
Create a new Java class named **UnityPlugin** under `MainActivity`.

---

## Unity Plugin Setup

### UnityPlugin.java
```java
package io.ionic.starter;

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
}
```

---

### Register Plugin in MainActivity.java
```java
package io.ionic.starter;

import android.os.Bundle;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        registerPlugin(UnityPlugin.class);
        super.onCreate(savedInstanceState);
    }
}
```

---

### Create Ionic Wrapper (unity.plugin.ts)
```ts
import { registerPlugin } from '@capacitor/core';

export interface UnityPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}

const Unity = registerPlugin<UnityPlugin>('Unity');
export default Unity;
```

---

## Connecting Unity Project

Use the Ionic plugin to launch Unity on button click.

See the reference commit for changes:  
[GitHub Commit Link](https://github.com/GaudRavi93/ionic-unity/commit/8dc3af28222a4abb96aa332680ae14537c324010)

---
