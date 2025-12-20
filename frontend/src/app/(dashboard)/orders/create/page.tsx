import { CreateOrderForm } from '@/components/orders/create-order-form';

export default function CreateOrderPage() {
  return (
    <div className="space-y-6">
      <div>
        <h1 className="text-3xl font-bold">Tạo đơn hàng mới</h1>
        <p className="text-muted-foreground">
          Tạo đơn hàng tại quầy nhanh chóng
        </p>
      </div>
      <CreateOrderForm />
    </div>
  );
}
