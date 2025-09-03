import Capacitor

@objc(UnityPlugin)
public class UnityPlugin: CAPPlugin, CAPBridgedPlugin {
    public let identifier = "UnityPlugin"
    public let jsName = "Unity"
    public let pluginMethods: [CAPPluginMethod] = [
        CAPPluginMethod(name: "echo", returnType: CAPPluginReturnPromise)
    ]

    @objc func echo(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        call.resolve(["value": value])
    }
}
