import { CustomerList } from '@/components/customers/customer-list';
import { Button } from '@/components/ui/button';
import { Plus } from 'lucide-react';
import Link from 'next/link';

export default function CustomersPage() {
  return (
    <div className="space-y-6">
      <div className="flex items-center justify-between">
        <div>
          <h1 className="text-3xl font-bold">Khách hàng</h1>
          <p className="text-muted-foreground">
            Quản lý thông tin khách hàng và công nợ
          </p>
        </div>
        <Link href="/customers/create">
          <Button>
            <Plus className="mr-2 h-4 w-4" />
            Thêm khách hàng
          </Button>
        </Link>
      </div>
      <CustomerList />
    </div>
  );
}
